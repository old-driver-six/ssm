package com.bj186.oas.pojo;

public class Proof {
    /**
     * 报销id
     */
    private Integer proofId;

    /**
     * 报销人员id（外键）
     */
    private Integer proofStaffid;

    /**
     * 审批部门（外键）
     */
    private Integer proofDepid;

    /**
     * 报销发票存在个人档案文件中
     */
    private String proofDocument;

    /**
     * 状态（审批通过，未通过，未审批）
     */
    private Integer proofCondition;

    /**
     * 报销id
     * @return proof_id 报销id
     */
    public Integer getProofId() {
        return proofId;
    }

    /**
     * 报销id
     * @param proofId 报销id
     */
    public void setProofId(Integer proofId) {
        this.proofId = proofId;
    }

    /**
     * 报销人员id（外键）
     * @return proof_staffid 报销人员id（外键）
     */
    public Integer getProofStaffid() {
        return proofStaffid;
    }

    /**
     * 报销人员id（外键）
     * @param proofStaffid 报销人员id（外键）
     */
    public void setProofStaffid(Integer proofStaffid) {
        this.proofStaffid = proofStaffid;
    }

    /**
     * 审批部门（外键）
     * @return proof_depid 审批部门（外键）
     */
    public Integer getProofDepid() {
        return proofDepid;
    }

    /**
     * 审批部门（外键）
     * @param proofDepid 审批部门（外键）
     */
    public void setProofDepid(Integer proofDepid) {
        this.proofDepid = proofDepid;
    }

    /**
     * 报销发票存在个人档案文件中
     * @return proof_document 报销发票存在个人档案文件中
     */
    public String getProofDocument() {
        return proofDocument;
    }

    /**
     * 报销发票存在个人档案文件中
     * @param proofDocument 报销发票存在个人档案文件中
     */
    public void setProofDocument(String proofDocument) {
        this.proofDocument = proofDocument == null ? null : proofDocument.trim();
    }

    /**
     * 状态（审批通过，未通过，未审批）
     * @return proof_condition 状态（审批通过，未通过，未审批）
     */
    public Integer getProofCondition() {
        return proofCondition;
    }

    /**
     * 状态（审批通过，未通过，未审批）
     * @param proofCondition 状态（审批通过，未通过，未审批）
     */
    public void setProofCondition(Integer proofCondition) {
        this.proofCondition = proofCondition;
    }
}