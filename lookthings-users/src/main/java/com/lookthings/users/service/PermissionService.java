package com.lookthings.users.service;

import com.github.pagehelper.PageInfo;
import com.lookthings.users.model.PermissionDO;

import java.util.List;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
public interface PermissionService {

    /**
     * Gets permission by page index.
     *
     * @param u        the u
     * @param pageNo   the page no
     * @param pageSize the page size
     * @return the permission by page index
     */
    PageInfo<PermissionDO> getPermissionByPageIndex(PermissionDO u, Integer pageNo, Integer pageSize);

    /**
     * Insert permission by permission info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean insertPermissionByPermissionInfo(List<PermissionDO> u);

    /**
     * Delete permission by permission info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean deletePermissionByPermissionInfo(List<Integer> u);

    /**
     * Update permission by permission info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean updatePermissionByPermissionInfo(List<PermissionDO> u);
}
