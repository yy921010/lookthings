package com.lookthings.users.model;

import java.util.Date;

/**
 * Created by Fantasy on 2018/1/21.
 *
 * @author Fantasy
 */
public class UserDO {
    private Integer id;
    private String userName;
    private String userPassword;
    private String userDescription;
    private String userMail;
    private Integer mailValid;
    private Integer roleId;
    private Date gmtCreate;
    private Date gmtModified;

    public Integer getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(Integer emailCode) {
        this.emailCode = emailCode;
    }

    private Integer emailCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Integer getMailValid() {
        return mailValid;
    }

    public void setMailValid(Integer mailValid) {
        this.mailValid = mailValid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", userMail='" + userMail + '\'' +
                ", mailValid=" + mailValid +
                ", roleId=" + roleId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", emailCode=" + emailCode +
                '}';
    }
}
