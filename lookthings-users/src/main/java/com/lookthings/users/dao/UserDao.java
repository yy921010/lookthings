package com.lookthings.users.dao;

import com.lookthings.users.dao.basic.BaseDao;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.model.RolePermsLinkDO;
import com.lookthings.users.model.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @author yy
 */
@Repository
public interface UserDao extends BaseDao<UserDO> {
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
     * @param rolePermsList the role perms link do
     * @return the integer
     */
    Boolean insertRolePermsLink(List<RolePermsLinkDO> rolePermsList);

}
