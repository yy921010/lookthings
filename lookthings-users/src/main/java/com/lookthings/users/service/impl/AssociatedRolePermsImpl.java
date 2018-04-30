package com.lookthings.users.service.impl;

import com.lookthings.users.dao.AssociationRolePermisDao;
import com.lookthings.users.model.AssociatedRolePermissionDO;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.service.AssociatedRolePermsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/4/30.
 *
 * @author Fantasy
 */
@Service("AssociatedRolePermsService")
public class AssociatedRolePermsImpl implements AssociatedRolePermsService {

    @Resource
    private AssociationRolePermisDao associationRolePermisDao;

    /**
     * Gets roles by user name.
     *
     * @param userName the user name
     * @return the roles by user name
     */
    @Override
    public Set<String> getRolesByUserName(String userName) {
        return associationRolePermisDao.getRolesByUserName(userName);
    }

    /**
     * Gets permissions by user name.
     *
     * @param userName the user name
     * @return the permissions by user name
     */
    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        return associationRolePermisDao.getPermissionsByUserName(userName);
    }

    /**
     * Gets permission by role id.
     *
     * @param roleId the role id
     * @return the permission by role id
     */
    @Override
    public List<PermissionDO> getPermissionByRoleId(Integer roleId) {
        return associationRolePermisDao.getPermissionByRoleId(roleId);
    }

    /**
     * Delete role perms by role id boolean.
     *
     * @param roleId the role id
     * @return the boolean
     */
    @Override
    public Boolean deleteRolePermsByRoleId(Integer roleId) {
        return associationRolePermisDao.deleteRolePermsByRoleId(roleId);
    }

    /**
     * Insert role perms link boolean.
     *
     * @param rolePermsList the role perms list
     * @return the boolean
     */
    @Override
    public Boolean insertRolePermsLink(List<AssociatedRolePermissionDO> associatedRolePermissionDOS) {
        return associationRolePermisDao.insertRolePermsLink(associatedRolePermissionDOS);
    }
}
