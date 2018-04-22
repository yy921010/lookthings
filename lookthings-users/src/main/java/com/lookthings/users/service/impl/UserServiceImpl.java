package com.lookthings.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lookthings.users.dao.UserDao;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public PageInfo<UserDO> getUsersByPageIndex(UserDO u, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<UserDO> userDOS = userDao.select(u);
        return (PageInfo<UserDO>) new PageInfo(userDOS);
    }

    @Override
    public Boolean deleteUserByUserInfo(Integer[] u) {
        return userDao.delete(u);
    }

    @Override
    public Boolean insertUserByUserInfo(List<UserDO> u) {
        return userDao.insert(u);
    }

    @Override
    public Boolean updateUserByUserInfo(List<UserDO> u) {
        return userDao.update(u);
    }
}
