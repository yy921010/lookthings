package com.lookthings.users.vo;

import java.util.List;

/**
 * Created by Fantasy on 2018/2/26.
 *
 * @author Fantasy
 */
public class RolePermsLinkVO {
    private Integer id;
    private Integer roleId;
    private List<Integer> permissionIds;

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

    public List<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }

    @Override
    public String toString() {
        return "RolePermsLinkVO{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionIds=" + permissionIds +
                '}';
    }
}
