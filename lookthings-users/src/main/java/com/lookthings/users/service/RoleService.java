package com.lookthings.users.service;

import com.github.pagehelper.PageInfo;
import com.lookthings.users.model.RoleDO;

import java.util.List;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
public interface RoleService {

    /**
     * Gets role by page index.
     *
     * @param u        the u
     * @param pageNo   the page no
     * @param pageSize the page size
     * @return the role by page index
     */
    PageInfo<RoleDO> getRoleByPageIndex(RoleDO u, Integer pageNo, Integer pageSize);


    /**
     * Insert role by role info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean insertRoleByRoleInfo(List<RoleDO> u);


    /**
     * Delete role by role info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean deleteRoleByRoleInfo(List<Integer> u);


    /**
     * Update role by role info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean updateRoleByRoleInfo(List<RoleDO> u);
}
