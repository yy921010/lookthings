package com.lookthings.users.service.impl;

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
    public List<UserDO> getUsersByUserInfo(UserDO u) {
        return userDao.select(u);
    }

    @Override
    public Boolean deleteUserByUserInfo(int[] u) {
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
