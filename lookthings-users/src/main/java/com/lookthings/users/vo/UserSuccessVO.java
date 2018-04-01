package com.lookthings.users.vo;

import java.util.List;

/**
 * Created by Fantasy on 2018/1/31.
 *
 * @author Fantasy
 */
public class UserSuccessVO {
    private String userName;
    private String roleName;
    private String sysDate;
    private List<Integer> userRolePermsCounts;
    private String ipAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }


    public List<Integer> getUserRolePermsCounts() {
        return userRolePermsCounts;
    }

    public void setUserRolePermsCounts(List<Integer> userRolePermsCounts) {
        this.userRolePermsCounts = userRolePermsCounts;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "UserSuccessVO{" +
                "userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", sysDate='" + sysDate + '\'' +
                ", userRolePermsCounts=" + userRolePermsCounts +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
