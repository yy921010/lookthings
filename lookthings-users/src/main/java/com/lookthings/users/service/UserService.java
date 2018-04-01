package com.lookthings.users.service;

import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.vo.RolePermsLinkVO;

import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @author Fantasy
 */
public interface UserService {
    /**
     * Find list user list.
     *
     * @param u the u
     * @return the list
     */
    List<UserDO> findListUser(UserDO u);

    /**
     * Insert user boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean insertUser(UserDO u);

    /**
     * Update user boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean updateUser(UserDO u);

    /**
     * Delete user boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean deleteUser(UserDO u);

    /**
     * Gets roles by user name.
     *
     * @param userName the user name
     * @return the roles by user name
     */
    Set<String> getRolesByUserName(String userName);

    /**
     * Gets permissions by user name.
     *
     * @param userName the user name
     * @return the permissions by user name
     */
    Set<String> getPermissionsByUserName(String userName);

    /**
     * User count integer.
     *
     * @return the integer
     */
    Integer userCount();

    /**
     * Gets permission by role id.
     *
     * @param roleId the role id
     * @return the permission by role id
     */
    List<PermissionDO> getPermissionByRoleId(Integer roleId);

    /**
     * Delete role perms by role id integer.
     *
     * @param roleId the role id
     * @return the integer
     */
    Boolean deleteRolePermsByRoleId(Integer roleId);

    /**
     * Insert role perms link integer.
     *
     * @param rolePermsLinkVO the role perms link do
     * @return the integer
     */
    Boolean insertRolePermsLink(RolePermsLinkVO rolePermsLinkVO);
}
