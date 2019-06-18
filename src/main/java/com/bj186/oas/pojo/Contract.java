package com.bj186.oas.pojo;

import java.util.Date;

public class Contract {
    /**
     * 合同ID(UUID去重)
     */
    private String contractId;

    /**
     * 合同甲方(公司)
     */
    private String contractFirstparty;

    /**
     * 合同乙方(员工)
     */
    private String contractSecondparty;

    /**
     * 合同乙方ID(员工ID,一个员工对应一个合同,外键到staff)
     */
    private Integer contractSecondpartyid;

    /**
     * 合同入职时间
     */
    private Date contractEntrydate;

    /**
     * 合同签订时间
     */
    private Date contractSigndate;

    /**
     * 合同薪资(外键到pay)
     */
    private Integer contractSalaryid;

    /**
     * 合同包含内容
     */
    private String contractContent;

    /**
     * 合同ID(UUID去重)
     * @return contract_id 合同ID(UUID去重)
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合同ID(UUID去重)
     * @param contractId 合同ID(UUID去重)
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 合同甲方(公司)
     * @return contract_firstParty 合同甲方(公司)
     */
    public String getContractFirstparty() {
        return contractFirstparty;
    }

    /**
     * 合同甲方(公司)
     * @param contractFirstparty 合同甲方(公司)
     */
    public void setContractFirstparty(String contractFirstparty) {
        this.contractFirstparty = contractFirstparty == null ? null : contractFirstparty.trim();
    }

    /**
     * 合同乙方(员工)
     * @return contract_secondParty 合同乙方(员工)
     */
    public String getContractSecondparty() {
        return contractSecondparty;
    }

    /**
     * 合同乙方(员工)
     * @param contractSecondparty 合同乙方(员工)
     */
    public void setContractSecondparty(String contractSecondparty) {
        this.contractSecondparty = contractSecondparty == null ? null : contractSecondparty.trim();
    }

    /**
     * 合同乙方ID(员工ID,一个员工对应一个合同,外键到staff)
     * @return contract_secondPartyId 合同乙方ID(员工ID,一个员工对应一个合同,外键到staff)
     */
    public Integer getContractSecondpartyid() {
        return contractSecondpartyid;
    }

    /**
     * 合同乙方ID(员工ID,一个员工对应一个合同,外键到staff)
     * @param contractSecondpartyid 合同乙方ID(员工ID,一个员工对应一个合同,外键到staff)
     */
    public void setContractSecondpartyid(Integer contractSecondpartyid) {
        this.contractSecondpartyid = contractSecondpartyid;
    }

    /**
     * 合同入职时间
     * @return contract_entryDate 合同入职时间
     */
    public Date getContractEntrydate() {
        return contractEntrydate;
    }

    /**
     * 合同入职时间
     * @param contractEntrydate 合同入职时间
     */
    public void setContractEntrydate(Date contractEntrydate) {
        this.contractEntrydate = contractEntrydate;
    }

    /**
     * 合同签订时间
     * @return contract_signDate 合同签订时间
     */
    public Date getContractSigndate() {
        return contractSigndate;
    }

    /**
     * 合同签订时间
     * @param contractSigndate 合同签订时间
     */
    public void setContractSigndate(Date contractSigndate) {
        this.contractSigndate = contractSigndate;
    }

    /**
     * 合同薪资(外键到pay)
     * @return contract_salaryId 合同薪资(外键到pay)
     */
    public Integer getContractSalaryid() {
        return contractSalaryid;
    }

    /**
     * 合同薪资(外键到pay)
     * @param contractSalaryid 合同薪资(外键到pay)
     */
    public void setContractSalaryid(Integer contractSalaryid) {
        this.contractSalaryid = contractSalaryid;
    }

    /**
     * 合同包含内容
     * @return contract_content 合同包含内容
     */
    public String getContractContent() {
        return contractContent;
    }

    /**
     * 合同包含内容
     * @param contractContent 合同包含内容
     */
    public void setContractContent(String contractContent) {
        this.contractContent = contractContent == null ? null : contractContent.trim();
    }
}