package com.bj186.oas.pojo.personalpojo;

import com.bj186.oas.pojo.WorkLog;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询工具类
 */
public class WorkLogUtil implements Serializable{
    private Integer worklogCreateid;        //通过创建人id查询

    private String workLogCreatedate1;        //通过创建时间区间查询
    private String workLogCreatedate2;        //通过创建时间区间查询

    private String worklogUpdatetime1;        //根据修改时间区间查询
    private String worklogUpdatetime2;        //根据修改时间区间查询

    private Integer pageSize;                   //每页大小
    private Integer pasgeThis;                  //当前是第几页

    public Integer getWorklogCreateid() {
        return worklogCreateid;
    }

    public void setWorklogCreateid(Integer worklogCreateid) {
        this.worklogCreateid = worklogCreateid;
    }

    public String getWorkLogCreatedate1() {
        return workLogCreatedate1;
    }

    public void setWorkLogCreatedate1(String workLogCreatedate1) {
        this.workLogCreatedate1 = workLogCreatedate1;
    }

    public String getWorklogUpdatetime1() {
        return worklogUpdatetime1;
    }

    public void setWorklogUpdatetime1(String worklogUpdatetime1) {
        this.worklogUpdatetime1 = worklogUpdatetime1;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPasgeThis() {
        return pasgeThis;
    }

    public void setPasgeThis(Integer pasgeThis) {
        this.pasgeThis = pasgeThis;
    }

    public String getWorkLogCreatedate2() {
        return workLogCreatedate2;
    }

    public void setWorkLogCreatedate2(String workLogCreatedate2) {
        this.workLogCreatedate2 = workLogCreatedate2;
    }

    public String getWorklogUpdatetime2() {
        return worklogUpdatetime2;
    }

    public void setWorklogUpdatetime2(String worklogUpdatetime2) {
        this.worklogUpdatetime2 = worklogUpdatetime2;
    }
}
