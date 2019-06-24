package com.bj186.oas.pojo;

import java.util.ArrayList;
import java.util.List;

public class Users {
    /**
     * 用户ID（主键 10001自动递增)
     */
    private Integer usersId;

    /**
     * 用户登录账号（外键 员工手机号 一对一）
     */
    private String usersPhone;

    /**
     * 密码（MD5 默认为手机号后六位）
     */
    private String usersPassword;

    /**
     * 账号有效状态（1为有效 0为无效）
     */
    private String usersState;

    /**
     * 权限
     */
    private List<Power> powerList = new ArrayList<>();

    public List<Power> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<Power> powerList) {
        this.powerList = powerList;
    }

    /**
     * 用户ID（主键 10001自动递增)
     * @return users_id 用户ID（主键 10001自动递增)
     */
    public Integer getUsersId() {
        return usersId;
    }

    /**
     * 用户ID（主键 10001自动递增)
     * @param usersId 用户ID（主键 10001自动递增)
     */
    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    /**
     * 用户登录账号（外键 员工手机号 一对一）
     * @return users_phone 用户登录账号（外键 员工手机号 一对一）
     */
    public String getUsersPhone() {
        return usersPhone;
    }

    /**
     * 用户登录账号（外键 员工手机号 一对一）
     * @param usersPhone 用户登录账号（外键 员工手机号 一对一）
     */
    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone == null ? null : usersPhone.trim();
    }

    /**
     * 密码（MD5 默认为手机号后六位）
     * @return users_password 密码（MD5 默认为手机号后六位）
     */
    public String getUsersPassword() {
        return usersPassword;
    }

    /**
     * 密码（MD5 默认为手机号后六位）
     * @param usersPassword 密码（MD5 默认为手机号后六位）
     */
    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword == null ? null : usersPassword.trim();
    }

    /**
     * 账号有效状态（1为有效 0为无效）
     * @return users_state 账号有效状态（1为有效 0为无效）
     */
    public String getUsersState() {
        return usersState;
    }

    /**
     * 账号有效状态（1为有效 0为无效）
     * @param usersState 账号有效状态（1为有效 0为无效）
     */
    public void setUsersState(String usersState) {
        this.usersState = usersState == null ? null : usersState.trim();
    }
}