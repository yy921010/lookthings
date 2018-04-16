package com.lookthings.users.model;

import java.util.Date;

/**
 * Created by Fantasy on 2018/4/16.
 *
 * @author Fantasy
 */
public class RolePermisAssociationDO {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
    private Date gmtCreate;
    private Date gmtModified;
    @Override
    public String toString() {
        return "RolePermisAssociation{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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
}
