package com.lookthings.users.service.impl;

import com.lookthings.users.dao.PermissionDao;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fantasy on 2018/1/22.
 *
 * @author Fantasy
 */
@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<PermissionDO> findListPermission(PermissionDO u) {
        return permissionDao.select(u);
    }

    @Override
    public Boolean insertPermission(PermissionDO u) {
        return permissionDao.insert(u);
    }

    @Override
    public Boolean updatePermission(PermissionDO u) {
        return permissionDao.update(u);
    }

    @Override
    public Boolean deletePermission(PermissionDO u) {
        return permissionDao.delete(u);
    }

    @Override
    public Integer permissionCount() {
        return permissionDao.permissionCount();
    }

}
