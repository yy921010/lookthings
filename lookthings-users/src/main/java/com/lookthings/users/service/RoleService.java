package com.lookthings.users.service;


import com.lookthings.users.model.RoleDO;

import java.util.List;

/**
 * Created by Fantasy on 2018/1/22.
 *
 * @author Fantasy
 */
public interface RoleService {
    /**
     * Find list role list.
     *
     * @param u the u
     * @return the list
     */
    List<RoleDO> findListRole(RoleDO u);

    /**
     * Insert role boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean insertRole(RoleDO u);

    /**
     * Update role boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean updateRole(RoleDO u);

    /**
     * Delete role boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean deleteRole(RoleDO u);

    /**
     * Role count integer.
     *
     * @return the integer
     */
    Integer roleCount();
}
