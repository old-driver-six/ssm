package com.bj186.oas.service.personal;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.WorkLog;
import com.bj186.oas.pojo.personalpojo.Paging;

import java.util.List;

public interface WorkLogService {
    /**
     * 添加日志
     * @param worklogName   日志标题
     * @param worklogCreateid  日志创建人id
     * @param worklogContent     日志内容
     * @return
     */
    OAResoult insertWorkLog(String worklogName,Integer worklogCreateid,String worklogContent) throws NullNameException;

    /**
     *  修改日志
     * @param workLog   日志实体类,必须包含id不然会异常
     * @return          修改的结果
     */
    OAResoult updateWorkLog(WorkLog workLog) throws NullNameException;

    /**
     * 删除日志,只能通过日志id删除
     * @param workid  要删除的日志id
     * @return         返回结果
     * @throws NullPointerException 可能会发生的异常
     */
    OAResoult deleteWorkLog(Integer workid) throws NullPointerException, NullNameException;

    /**
     * 查询个人日志所有日志
     * @return
     */
    OAResoult<List<WorkLog>> selWorkLog(Integer sid);

    /**
     * 查询个人日志分页版本
     * @param sid
     * @param pageSize
     * @param pageThis
     * @return
     */
    OAResoult<List<WorkLog>> selWorkLog(Integer sid, Integer pageSize, Integer pageThis);

    /**
     * 根据创建时间区间查询,
     * 最高权限的人才能调用这个方法,可以查询出所有日志
     * @param createDate1 将要大于的时间
     * @param createDate2 将要小于的时间
     * @param type 查询的类型,1为创建时间 2位修改时间 默认为1
     * @return  日志集合
     */
    OAResoult<List<WorkLog>> selWorkLog(String createDate1,String createDate2,Integer type);

    /**
     *
     *  据创建时间区间查询,
     * 最高权限的人才能调用这个方法,可以查询出所有日志
     * @param createDate1 将要大于的时间
     * @param createDate2 将要小于的时间
     * @param type 查询的类型,1为创建时间 2位修改时间 默认为1
     * @param pageSize 页面显示多少条
     * @param pageThis  当前页
     * @return
     */
    OAResoult<Paging<WorkLog>> selWorkLog(String createDate1,String createDate2,Integer type,Integer pageSize, Integer pageThis);

    /**
     * 普通用户具有的权限,查询自己的日志信息
     * @param createDate1
     * @param createDate2
     * @param type
     * @param sid
     * @return
     */
    OAResoult<List<WorkLog>> selWorkLog(String createDate1,String createDate2,Integer type,Integer sid);

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
    OAResoult<Paging<WorkLog>> selWorkLog(String createDate1,String createDate2,Integer type,Integer sid,Integer pageSize, Integer pageThis);




}
