package com.lookthings.users.service.impl;

import com.lookthings.users.dao.UserDao;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.model.RolePermsLinkDO;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import com.lookthings.users.vo.RolePermsLinkVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @author Fantasy
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<UserDO> findListUser(UserDO u) {
        return userDao.select(u);
    }

    @Override
    public Boolean insertUser(UserDO u) {
        return userDao.insert(u);
    }

    @Override
    public Boolean updateUser(UserDO u) {
        return userDao.update(u);
    }

    @Override
    public Boolean deleteUser(UserDO u) {
        return userDao.delete(u);
    }

    @Override
    public Set<String> getRolesByUserName(String userName) {
        return userDao.getRolesByUserName(userName);
    }

    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        return userDao.getPermissionsByUserName(userName);
    }

    @Override
    public Integer userCount() {
        return userDao.userCount();
    }

    @Override
    public List<PermissionDO> getPermissionByRoleId(Integer roleId) {
        return userDao.getPermissionByRoleId(roleId);
    }

    @Override
    public Boolean deleteRolePermsByRoleId(Integer roleId) {
        return userDao.deleteRolePermsByRoleId(roleId);
    }

    @Override
    public Boolean insertRolePermsLink(RolePermsLinkVO rolePermsLinkVO) {
        List<Integer> permissionIds = rolePermsLinkVO.getPermissionIds();
        List<RolePermsLinkDO> rolePermsLinkDOList = new ArrayList<RolePermsLinkDO>();
        RolePermsLinkDO rolePermsLinkDO;
        for (Integer permsId : permissionIds) {
            rolePermsLinkDO = new RolePermsLinkDO();
            rolePermsLinkDO.setPermissionId(permsId);
            rolePermsLinkDO.setRoleId(rolePermsLinkVO.getRoleId());
            rolePermsLinkDOList.add(rolePermsLinkDO);
        }
        return userDao.insertRolePermsLink(rolePermsLinkDOList);
    }
}
