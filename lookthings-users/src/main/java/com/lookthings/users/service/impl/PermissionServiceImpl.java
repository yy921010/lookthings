package com.lookthings.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lookthings.users.dao.PermissionDao;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public PageInfo<PermissionDO> getPermissionByPageIndex(PermissionDO u, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<PermissionDO> roleDos = permissionDao.select(u);
        return (PageInfo<PermissionDO>) new PageInfo(roleDos);
    }

    @Override
    public Boolean insertPermissionByPermissionInfo(List<PermissionDO> u) {
        return permissionDao.insert(u);
    }

    @Override
    public Boolean deletePermissionByPermissionInfo(List<Integer> u) {
        return permissionDao.delete(u);
    }

    @Override
    public Boolean updatePermissionByPermissionInfo(List<PermissionDO> u) {
        return permissionDao.update(u);
    }
}
