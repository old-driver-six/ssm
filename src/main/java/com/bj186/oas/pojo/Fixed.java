package com.bj186.oas.pojo;

import java.math.BigDecimal;

public class Fixed {
    /**
     * 固定资产id（主键）
     */
    private Integer fixId;

    /**
     * 资产名称
     */
    private String fixeName;

    /**
     * 单位（个）
     */
    private Integer fixUnit;

    /**
     * 数量
     */
    private Integer fixNumber;

    /**
     * 总计金额
     */
    private BigDecimal fixAmount;

    /**
     * 备注
     */
    private String fixRemarks;

    /**
     * 固定资产id（主键）
     * @return fix_id 固定资产id（主键）
     */
    public Integer getFixId() {
        return fixId;
    }

    /**
     * 固定资产id（主键）
     * @param fixId 固定资产id（主键）
     */
    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    /**
     * 资产名称
     * @return fixe_name 资产名称
     */
    public String getFixeName() {
        return fixeName;
    }

    /**
     * 资产名称
     * @param fixeName 资产名称
     */
    public void setFixeName(String fixeName) {
        this.fixeName = fixeName == null ? null : fixeName.trim();
    }

    /**
     * 单位（个）
     * @return fix_unit 单位（个）
     */
    public Integer getFixUnit() {
        return fixUnit;
    }

    /**
     * 单位（个）
     * @param fixUnit 单位（个）
     */
    public void setFixUnit(Integer fixUnit) {
        this.fixUnit = fixUnit;
    }

    /**
     * 数量
     * @return fix_number 数量
     */
    public Integer getFixNumber() {
        return fixNumber;
    }

    /**
     * 数量
     * @param fixNumber 数量
     */
    public void setFixNumber(Integer fixNumber) {
        this.fixNumber = fixNumber;
    }

    /**
     * 总计金额
     * @return fix_ amount 总计金额
     */
    public BigDecimal getFixAmount() {
        return fixAmount;
    }

    /**
     * 总计金额
     * @param fixAmount 总计金额
     */
    public void setFixAmount(BigDecimal fixAmount) {
        this.fixAmount = fixAmount;
    }

    /**
     * 备注
     * @return fix_remarks 备注
     */
    public String getFixRemarks() {
        return fixRemarks;
    }

    /**
     * 备注
     * @param fixRemarks 备注
     */
    public void setFixRemarks(String fixRemarks) {
        this.fixRemarks = fixRemarks == null ? null : fixRemarks.trim();
    }
}