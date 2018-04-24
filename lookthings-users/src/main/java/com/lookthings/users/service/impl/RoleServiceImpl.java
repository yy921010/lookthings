package com.lookthings.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lookthings.users.dao.RoleDao;
import com.lookthings.users.model.RoleDO;
import com.lookthings.users.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {


    @Resource
    private RoleDao roleDao;

    /**
     * Gets role by page index.
     *
     * @param u        the u
     * @param pageNo   the page no
     * @param pageSize the page size
     * @return the role by page index
     */
    @Override
    public PageInfo<RoleDO> getRoleByPageIndex(RoleDO u, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<RoleDO> roleDos = roleDao.select(u);
        return (PageInfo<RoleDO>) new PageInfo(roleDos);
    }

    /**
     * Insert role by role info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    @Override
    public Boolean insertRoleByRoleInfo(List<RoleDO> u) {
        return roleDao.insert(u);
    }

    /**
     * Delete role by role info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    @Override
    public Boolean deleteRoleByRoleInfo(List<Integer> u) {
        return roleDao.delete(u);
    }

    /**
     * Update role by role info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    @Override
    public Boolean updateRoleByRoleInfo(List<RoleDO> u) {
        return roleDao.update(u);
    }
}
