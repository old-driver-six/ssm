package com.bj186.oas.pojo.personalpojo;

import java.io.Serializable;

/**
 * 传分页值过来的工具类,查询工具类
 */
public class Page<T> implements Serializable {
    private Integer pageSize;                   //每页大小
    private Integer pageThis;                  //当前是第几页
    private Integer sid;                       //当前用户的id
    private T entity;                          //实体类

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageThis() {
        return pageThis;
    }

    public void setPageThis(Integer pageThis) {
        this.pageThis = pageThis;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", pageThis=" + pageThis +
                ", sid=" + sid +
                '}';
    }
}
