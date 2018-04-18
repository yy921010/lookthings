package com.lookthings.users.dao;

import com.lookthings.users.BaseTest;
import com.lookthings.users.model.UserDO;
import org.junit.Test;

import javax.annotation.Resource;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Fantasy on 2018/4/19.
 *
 * @author Fantasy
 */
public class UserDaoTest extends BaseTest {
    @Resource
    private UserDao userDao;

    @Test
    public void TestUser() {
        UserDO userDO = new UserDO();
        userDO.setId(1);
        System.out.println(userDao.select(userDO));
        assertEquals(1, 1);
    }
}
