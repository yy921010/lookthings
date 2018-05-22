package com.lookthings.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lookthings.users.dao.UserDao;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Override
    public PageInfo<UserDO> getUsersByPageIndex(UserDO u, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<UserDO> userDOS = userDao.select(u);
        return (PageInfo<UserDO>) new PageInfo(userDOS);
    }

    @Override
    public List<UserDO> getUsersByPageIndex(UserDO u) {
        return userDao.select(u);
    }

    @Override
    public Boolean deleteUserByUserInfo(List<Integer> u) {
        return userDao.delete(u);
    }

    @Override
    public Boolean insertUserByUserInfo(List<UserDO> u) {
        return userDao.insert(u);
    }

    @Override
    public Boolean updateUserByUserInfo(List<UserDO> u) {
        u.forEach(user -> {
            user.setGmtModified(new Date());
            log.info("[updateUserByUserInfo] [user]" + user.toString());
        });
        return userDao.update(u);
    }

    /**
     * Find user model by user name user do.
     *
     * @param userName the user name
     * @return the user do
     */
    @Override
    public UserDO findUserModelByUserName(String userName) {
        return userDao.findUserModelByUserName(userName);
    }
}
