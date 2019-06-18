package com.bj186.oas.pojo;

import java.util.Date;

public class Files {
    /**
     * 档案ID(UUID)
     */
    private Integer filesId;

    /**
     * 档案对应员工ID(外键到staff)
     */
    private Integer filesStaffid;

    /**
     * 档案转入时间
     */
    private Date filesEnterdate;

    /**
     * 档案转出时间
     */
    private Date filesRemovedate;

    /**
     * 该档案中的合同ID(外键到contract)
     */
    private Integer filesContractid;

    /**
     * 档案位置
     */
    private String filesPosition;

    /**
     * 档案ID(UUID)
     * @return files_id 档案ID(UUID)
     */
    public Integer getFilesId() {
        return filesId;
    }

    /**
     * 档案ID(UUID)
     * @param filesId 档案ID(UUID)
     */
    public void setFilesId(Integer filesId) {
        this.filesId = filesId;
    }

    /**
     * 档案对应员工ID(外键到staff)
     * @return files_staffId 档案对应员工ID(外键到staff)
     */
    public Integer getFilesStaffid() {
        return filesStaffid;
    }

    /**
     * 档案对应员工ID(外键到staff)
     * @param filesStaffid 档案对应员工ID(外键到staff)
     */
    public void setFilesStaffid(Integer filesStaffid) {
        this.filesStaffid = filesStaffid;
    }

    /**
     * 档案转入时间
     * @return files_enterDate 档案转入时间
     */
    public Date getFilesEnterdate() {
        return filesEnterdate;
    }

    /**
     * 档案转入时间
     * @param filesEnterdate 档案转入时间
     */
    public void setFilesEnterdate(Date filesEnterdate) {
        this.filesEnterdate = filesEnterdate;
    }

    /**
     * 档案转出时间
     * @return files_removeDate 档案转出时间
     */
    public Date getFilesRemovedate() {
        return filesRemovedate;
    }

    /**
     * 档案转出时间
     * @param filesRemovedate 档案转出时间
     */
    public void setFilesRemovedate(Date filesRemovedate) {
        this.filesRemovedate = filesRemovedate;
    }

    /**
     * 该档案中的合同ID(外键到contract)
     * @return files_contractId 该档案中的合同ID(外键到contract)
     */
    public Integer getFilesContractid() {
        return filesContractid;
    }

    /**
     * 该档案中的合同ID(外键到contract)
     * @param filesContractid 该档案中的合同ID(外键到contract)
     */
    public void setFilesContractid(Integer filesContractid) {
        this.filesContractid = filesContractid;
    }

    /**
     * 档案位置
     * @return files_position 档案位置
     */
    public String getFilesPosition() {
        return filesPosition;
    }

    /**
     * 档案位置
     * @param filesPosition 档案位置
     */
    public void setFilesPosition(String filesPosition) {
        this.filesPosition = filesPosition == null ? null : filesPosition.trim();
    }
}