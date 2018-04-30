package com.lookthings.users.model;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
public class AssociatedRolePermissionDO {

    private Integer id;
    private Integer roleId;
    private Integer permissionId;
    private Date gmtCreate;
    private Data gmtModified;

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

    public Data getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Data gmtModified) {
        this.gmtModified = gmtModified;
    }

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
}
