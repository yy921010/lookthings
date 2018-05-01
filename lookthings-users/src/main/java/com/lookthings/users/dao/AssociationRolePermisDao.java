package com.lookthings.users.dao;

import com.lookthings.users.model.AssociatedRolePermissionDO;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.model.RoleDO;

import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
public interface AssociationRolePermisDao {

    /**
     * Gets roles by user name.
     *
     * @param userName the user name
     * @return the roles by user name
     */
    Set<String> getRolesNameByUserName(String userName);

    /**
     * Gets roles by user name.
     *
     * @param userId the user id
     * @return the roles by user name
     */
    List<RoleDO> getRolesByUserName(Integer userId);

    /**
     * Gets permissions by user name.
     *
     * @param userName the user name
     * @return the permissions by user name
     */
    Set<String> getPermissionsByUserName(String userName);


    /**
     * Gets permission by role id.
     *
     * @param roleId the role id
     * @return the permission by role id
     */
    List<PermissionDO> getPermissionByRoleId(Integer roleId);

    /**
     * Delete role perms by role id boolean.
     *
     * @param roleId the role id
     * @return the boolean
     */
    Boolean deleteRolePermsByRoleId(Integer roleId);

    /**
     * Insert role perms link boolean.
     *
     * @param rolePermsList the role perms list
     * @return the boolean
     */
    Boolean insertRolePermsLink(List<AssociatedRolePermissionDO> rolePermsList);
}
