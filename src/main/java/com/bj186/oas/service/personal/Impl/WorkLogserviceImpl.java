package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.mapper.WorkLogMapper;
import com.bj186.oas.pojo.WorkLog;
import com.bj186.oas.pojo.personalpojo.Paging;
import com.bj186.oas.pojo.personalpojo.WorkLogUtil;
import com.bj186.oas.service.personal.WorkLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("workLogService")
public class WorkLogserviceImpl implements WorkLogService {
    @Resource
    private WorkLogMapper workLogMapper;

    /**
     *
     * @param worklogName   日志标题
     * @param worklogCreateid  日志创建人id
     * @param worklogContent     日志内容
     * @return
     * @throws NullNameException
     */
    @Override
    public OAResoult insertWorkLog(String worklogName, Integer worklogCreateid, String worklogContent) throws NullNameException {
        WorkLog workLog=new WorkLog();
        workLog.setWorklogContent(worklogContent);      //添加日志内容
        workLog.setWorklogCreateid(worklogCreateid);    //添加日志创建人id
        workLog.setWorklogName(worklogName);            //添加日志标题
        workLog.setWorklogCreatedate(new Date());
        int insert = workLogMapper.insert(workLog);
        if (insert==0){                             //如果插入失败,抛出异常让事物回滚!
            throw new NullNameException("添加数据失败!");
        }
        OAResoult oaResoult=new OAResoult();
        oaResoult.setCode(0);
        oaResoult.setMsg("添加数据成功!");
        return oaResoult;
    }

    /**
     * 修改日志
     * @param workLog   日志实体类,必须包含id不然会异常
     * @return
     */
    @Override
    public OAResoult updateWorkLog(WorkLog workLog) throws NullNameException {
        int update = workLogMapper.updateByPrimaryKeySelective(workLog);
        if(update==0){
            throw new NullNameException("修改失败!请稍后重试");
        }
        OAResoult resoult=new OAResoult();
        resoult.setCode(0);
        resoult.setMsg("修改成功!");
        return null;
    }

    /**
     *
     * @param workid  要删除的日志id
     * @return
     * @throws NullPointerException
     */
    @Override
    public OAResoult deleteWorkLog(Integer workid) throws NullPointerException, NullNameException {
        int delete = workLogMapper.deleteByPrimaryKey(workid);
        if(delete==0){
            throw new NullNameException("删除失败!请稍后重试!");
        }
        OAResoult resoult=new OAResoult();
        resoult.setCode(0);
        resoult.setMsg("删除成功!");
        return  resoult;
    }

    /**
     * 查询个人的日志信息!
     * @param sid   工号
     * @return      日志消息集合
     */
    @Override
    public OAResoult<List<WorkLog>> selWorkLog(Integer sid) {
        WorkLogUtil workLogUtil=new WorkLogUtil();
        workLogUtil.setWorklogCreateid(sid);
        List<WorkLog> workLogs = workLogMapper.selectWorkBymapper(workLogUtil);
        OAResoult<List<WorkLog>> resoult=new OAResoult<>();
        resoult.setCode(0);
        resoult.setData(workLogs);
        return resoult;
    }

    /**
     * 查询个人日志分页
     * @param sid   工号
     * @param pageSize  页面显示大小
     * @param pageThis  当前页
     * @return
     */
    @Override
    public OAResoult<List<WorkLog>> selWorkLog(Integer sid, Integer pageSize, Integer pageThis) {
        WorkLogUtil util = getWorkLogUtil(pageThis, pageSize);
        util.setWorklogCreateid(sid);
        Paging<WorkLog> workLogPaging = workLogMapper.selLimitWork(util);
        OAResoult<List<WorkLog>> resoult=new OAResoult<>();
        resoult.setCode(0);
        if("".equals(workLogPaging)||null==workLogPaging){
            resoult.setMsg("当前还没有添加数据！");
            return resoult;
        }
        resoult.setCount(workLogPaging.getCot());
        resoult.setData(workLogPaging.getData());
        return resoult;
    }

    /**
     * 更具创建时间查询
     * @param createDate1 将要大于的时间
     * @param createDate2 将要小于的时间
     * @return
     */
    @Override
    public OAResoult<List<WorkLog>> selWorkLog(String createDate1, String createDate2,Integer type) {
        WorkLogUtil util = getWorkLogUtil(createDate1, createDate2, type);
        List<WorkLog> workLogs;
        workLogs = workLogMapper.selectWorkBymapper(util);
        OAResoult<List<WorkLog>> resoult=new OAResoult<>();
        resoult.setCode(0);
        resoult.setData(workLogs);
        return resoult;
    }

    /**
     * 更具创建时间分页查询
     * 最高权限的人才能调用这个方法,可以查询出所有日志
     * @param createDate1 将要大于的时间
     * @param createDate2 将要小于的时间
     * @param type 查询的类型,1为创建时间 2位修改时间 默认为1
     * @param pageSize 页面显示多少条
     * @param pageThis  当前页
     * @return
     */
    @Override
    public OAResoult<Paging<WorkLog>> selWorkLog(String createDate1, String createDate2, Integer type, Integer pageSize, Integer pageThis) {
        WorkLogUtil util = getWorkLogUtil(createDate1, createDate2, type);
        util = getWorkLogUtil(pageThis, pageSize, util);
        Paging<WorkLog> workLogPaging = workLogMapper.selLimitWork(util);   //获取查询结果

        //创建返回结果集
        OAResoult<Paging<WorkLog>> resoult=new OAResoult<>();
        resoult.setCode(0);
        if(workLogPaging!=null||"".equals(workLogPaging)){
            resoult.setMsg("当前查询条没有数据!");
            return resoult;
        }
        resoult.setData(workLogPaging);
        return resoult;
    }

    /**
     * 普通用户具有的权限,查询自己的日志信息
     * @param createDate1 将要大于的时间
     * @param createDate2 将要小于的时间
     * @param type          查询的类型,1为创建时间 2位修改时间 默认为1
     * @param sid           工号
     * @return
     */
    @Override
    public OAResoult<List<WorkLog>> selWorkLog(String createDate1, String createDate2, Integer type, Integer sid) {
        WorkLogUtil util = getWorkLogUtil(createDate1, createDate2, type);
        util.setWorklogCreateid(sid);
        List<WorkLog> workLogs;
        workLogs = workLogMapper.selectWorkBymapper(util);
        OAResoult<List<WorkLog>> resoult=new OAResoult<>();
        resoult.setCode(0);
        resoult.setData(workLogs);
        return resoult;
    }

    /**
     * 普通用户具有的权限,查询自己的日志信息
     * @param createDate1
     * @param createDate2
     * @param type
     * @param sid
     * @param pageSize
     * @param pageThis
     * @return
     */
    @Override
    public OAResoult<Paging<WorkLog>> selWorkLog(String createDate1, String createDate2, Integer type, Integer sid, Integer pageSize, Integer pageThis) {
        WorkLogUtil util = getWorkLogUtil(createDate1, createDate2, type);
        util=getWorkLogUtil(pageThis,pageSize,util);
        util.setWorklogCreateid(sid);
        Paging<WorkLog> workLogPaging = workLogMapper.selLimitWork(util);
        OAResoult<Paging<WorkLog>> resoult=new OAResoult<>();
        resoult.setCode(0);
        if("".equals(workLogPaging)||null==workLogPaging){
            resoult.setMsg("当前查询条没有数据!");
            return resoult;
        }
        resoult.setData(workLogPaging);
        return resoult;
    }


    /**
     * 组装查询条件实体类
     * @param createDate1 时间一
     * @param createDate2 时间二
     * @param type  类型
     * @return  工具实体类
     */
    private WorkLogUtil getWorkLogUtil(String createDate1, String createDate2, Integer type){
        createDate1=createDate1+"%";        //传递过来的时间可能没有百分号需要加上
        createDate2=createDate2+"%";
        WorkLogUtil util=new WorkLogUtil();
        if(type==2){
            util.setWorklogUpdatetime1(createDate1);
            util.setWorklogUpdatetime2(createDate2);

        }else{
            util.setWorkLogCreatedate1(createDate1);
            util.setWorkLogCreatedate2(createDate2);
        }
        return util;
    }

    /**
     * 组装查询条件实体类
     * @param pageThis  当前页
     * @param pageSize  页面显示多少条
     * @return  工具实体类
     */
    private WorkLogUtil getWorkLogUtil(Integer pageThis,Integer pageSize){
        WorkLogUtil util=new WorkLogUtil();
        util.setPageThis((pageThis-1)*pageSize);
        util.setPageSize(pageSize);
        return util;
    }

    /**
     *
     * 连接组装查询条件实体类
     * @param pageThis  当前页
     * @param pageSize  页面显示多少条
     * @param util      实体类
     * @return 工具实体类
     */
    private WorkLogUtil getWorkLogUtil(Integer pageThis,Integer pageSize,WorkLogUtil util){
        util.setPageThis((pageThis-1)*pageSize);
        util.setPageSize(pageSize);
        return util;
    }
}
