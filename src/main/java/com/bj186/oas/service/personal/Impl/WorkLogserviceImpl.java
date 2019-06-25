package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.mapper.WorkLogMapper;
import com.bj186.oas.pojo.WorkLog;
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
     * 更具创建时间查询
     * @param createDate1 将要大于的时间
     * @param createDate2 将要小于的时间
     * @return
     */
    @Override
    public OAResoult<List<WorkLog>> selWorkLog(String createDate1, String createDate2) {
        WorkLogUtil util=new WorkLogUtil();
        return null;
    }


}
