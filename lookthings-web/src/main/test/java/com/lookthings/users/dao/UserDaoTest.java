package com.lookthings.users.dao;

import com.lookthings.core.utils.EmailUtils;
import com.lookthings.core.utils.SystemUtils;
import com.lookthings.users.BaseTest;
import com.lookthings.users.model.UserDO;

import org.junit.Test;

import javax.annotation.Resource;


import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

    @Test
    public void TestInsertUser() {
        List<UserDO> userDOS = new ArrayList();
        for (int i = 0; i < 6; i++) {
            UserDO userDO = new UserDO();
            userDO.setMailValid(1);
            userDO.setUserName(Math.random() + "User");
            userDO.setUserDescription(Math.random() + "UserDescription");
            userDO.setUserPassword(Math.random() + "UserPassword");
            userDO.setUserMail(Math.random() + "UserMail");
            userDO.setRoleId(i);
            userDOS.add(userDO);
        }
        System.out.println(userDao.insert(userDOS));
    }

    @Test
    public void TestUpdateUser() {
        List<UserDO> userDOS = new ArrayList();
        for (int i = 0; i < 6; i++) {
            UserDO userDO = new UserDO();
            userDO.setId(i);
            userDO.setMailValid(1);
            userDO.setUserName(Math.random() + "User");
            userDO.setUserDescription(Math.random() + "UserDescription");
            userDO.setUserPassword(Math.random() + "UserPassword");
            userDO.setUserMail(Math.random() + "UserMail");
            userDO.setRoleId(i);
            userDOS.add(userDO);
        }
        System.out.println(userDao.update(userDOS));
    }

    @Test
    public void TestDeleteUser() {
        //System.out.println(userDao.delete(userids));
    }


    @Test
    public void TestEmail() throws GeneralSecurityException {
        EmailUtils.emailUrl = "charlesmaxwellyoung@gmail.com";
        EmailUtils.subjectTitle = "这是一个测试";
        EmailUtils.subjectContent = "测试内容";
        EmailUtils.sendEmail();
    }

    @Test
    public void TestRandomNumber() {
        EmailUtils.emailUrl = "charlesmaxwellyoung@gmail.com";
        EmailUtils.subjectTitle = "TEST";
        EmailUtils.subjectContent = "123456";
        EmailUtils.sendEmail();
        System.out.println(SystemUtils.getRandomNumber(1, 999999));
    }




}
