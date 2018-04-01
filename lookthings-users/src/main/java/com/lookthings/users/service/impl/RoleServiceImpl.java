package com.lookthings.users.service.impl;

import com.lookthings.users.dao.RoleDao;
import com.lookthings.users.model.RoleDO;
import com.lookthings.users.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fantasy on 2018/1/22.
 *
 * @author Fantasy
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public List<RoleDO> findListRole(RoleDO u) {
        return roleDao.select(u);
    }

    @Override
    public Boolean insertRole(RoleDO u) {
        return roleDao.insert(u);
    }

    @Override
    public Boolean updateRole(RoleDO u) {
        return roleDao.update(u);
    }

    @Override
    public Boolean deleteRole(RoleDO u) {
        return roleDao.delete(u);
    }

    @Override
    public Integer roleCount() {
        return roleDao.roleCount();
    }
}
