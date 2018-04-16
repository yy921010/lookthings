package com.lookthings.users.model;

import java.util.Date;

/**
 * Created by Fantasy on 2018/1/21.
 *
 * @author Fantasy
 */
public class RoleDO {
    private Integer id;
    private String roleName;
    private Date gmtCreate;
    private Date gmtModified;
    private String roleDescription;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        return "RoleDO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
