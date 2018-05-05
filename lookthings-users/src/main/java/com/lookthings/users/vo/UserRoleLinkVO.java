package com.lookthings.users.vo;

/**
 * Created by Fantasy on 2018/5/2.
 *
 * @author Fantasy
 */
public class UserRoleLinkVO {
    private String roleName;
    private Integer roleId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleLinkVO{" +
                "roleName='" + roleName + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
