package com.bj186.oas.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Reimburse {
    /**
     * 报销编号（主键）
     */
    private Integer reimId;

    /**
     * 员工编号（外键）
     */
    private Integer reimStaffid;

    /**
     * 部门编号（外键）
     */
    private Integer reimDepid;

    /**
     * 出差事由
     */
    private String reimMatter;

    /**
     * 出差开始时间
     */
    private Date reimStarttime;

    /**
     * 出差结束时间
     */
    private Date reimEndtime;

    /**
     * 出差地
     */
    private String reimPlace;

    /**
     * 交通费用
     */
    private BigDecimal reimTraffic;

    /**
     * 住宿费用
     */
    private BigDecimal reimStay;

    /**
     * 其他费用
     */
    private BigDecimal reimReferr;

    /**
     * 报销编号（主键）
     * @return reim_id 报销编号（主键）
     */
    public Integer getReimId() {
        return reimId;
    }

    /**
     * 报销编号（主键）
     * @param reimId 报销编号（主键）
     */
    public void setReimId(Integer reimId) {
        this.reimId = reimId;
    }

    /**
     * 员工编号（外键）
     * @return reim_staffid 员工编号（外键）
     */
    public Integer getReimStaffid() {
        return reimStaffid;
    }

    /**
     * 员工编号（外键）
     * @param reimStaffid 员工编号（外键）
     */
    public void setReimStaffid(Integer reimStaffid) {
        this.reimStaffid = reimStaffid;
    }

    /**
     * 部门编号（外键）
     * @return reim_depid 部门编号（外键）
     */
    public Integer getReimDepid() {
        return reimDepid;
    }

    /**
     * 部门编号（外键）
     * @param reimDepid 部门编号（外键）
     */
    public void setReimDepid(Integer reimDepid) {
        this.reimDepid = reimDepid;
    }

    /**
     * 出差事由
     * @return reim_matter 出差事由
     */
    public String getReimMatter() {
        return reimMatter;
    }

    /**
     * 出差事由
     * @param reimMatter 出差事由
     */
    public void setReimMatter(String reimMatter) {
        this.reimMatter = reimMatter == null ? null : reimMatter.trim();
    }

    /**
     * 出差开始时间
     * @return reim_starttime 出差开始时间
     */
    public Date getReimStarttime() {
        return reimStarttime;
    }

    /**
     * 出差开始时间
     * @param reimStarttime 出差开始时间
     */
    public void setReimStarttime(Date reimStarttime) {
        this.reimStarttime = reimStarttime;
    }

    /**
     * 出差结束时间
     * @return reim_endtime 出差结束时间
     */
    public Date getReimEndtime() {
        return reimEndtime;
    }

    /**
     * 出差结束时间
     * @param reimEndtime 出差结束时间
     */
    public void setReimEndtime(Date reimEndtime) {
        this.reimEndtime = reimEndtime;
    }

    /**
     * 出差地
     * @return reim_place 出差地
     */
    public String getReimPlace() {
        return reimPlace;
    }

    /**
     * 出差地
     * @param reimPlace 出差地
     */
    public void setReimPlace(String reimPlace) {
        this.reimPlace = reimPlace == null ? null : reimPlace.trim();
    }

    /**
     * 交通费用
     * @return reim_traffic 交通费用
     */
    public BigDecimal getReimTraffic() {
        return reimTraffic;
    }

    /**
     * 交通费用
     * @param reimTraffic 交通费用
     */
    public void setReimTraffic(BigDecimal reimTraffic) {
        this.reimTraffic = reimTraffic;
    }

    /**
     * 住宿费用
     * @return reim_stay 住宿费用
     */
    public BigDecimal getReimStay() {
        return reimStay;
    }

    /**
     * 住宿费用
     * @param reimStay 住宿费用
     */
    public void setReimStay(BigDecimal reimStay) {
        this.reimStay = reimStay;
    }

    /**
     * 其他费用
     * @return reim_referr 其他费用
     */
    public BigDecimal getReimReferr() {
        return reimReferr;
    }

    /**
     * 其他费用
     * @param reimReferr 其他费用
     */
    public void setReimReferr(BigDecimal reimReferr) {
        this.reimReferr = reimReferr;
    }
}