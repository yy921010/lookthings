package com.lookthings.users.controller;

import com.lookthings.core.json.JsonResult;
import com.lookthings.core.service.impl.CommonConfig;
import com.lookthings.core.service.impl.LoginError;
import com.lookthings.core.service.impl.UserErrorCode;
import com.lookthings.core.utils.EmailUtils;
import com.lookthings.core.utils.SystemUtils;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("userLoginModule")
public class UserLoginController {

    @Resource
    private UserService userService;

    @Resource
    private CommonConfig commonConfig;


    @Resource
    private LoginError loginError;

    @Resource
    private UserErrorCode userErrorCode;

    /**
     * 用来进行用户注册
     *
     * @param userDO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userSign")
    public JsonResult<String> userSignUp(@RequestBody UserDO userDO) {
        boolean isInsertStatus;
        if (null != userDO.getUserName()) {
            List<UserDO> userBeans = userService.getUsersByPageIndex(userDO);
            List<UserDO> userDOList = new ArrayList<>();
            if (0 != userBeans.size()) {
                return new JsonResult(false, "用户已经存在", loginError.getAccount());
            } else {
                ByteSource salt = ByteSource.Util.bytes(commonConfig.getIsaKey());
                SimpleHash simpleHashPassword = new SimpleHash("md5", userDO.getUserPassword(), salt, 2);
                userDO.setUserPassword(simpleHashPassword.toString());
                userDO.setMailValid(0);
                userDOList.add(userDO);
                isInsertStatus = userService.insertUserByUserInfo(userDOList);
                String msg;
                if (isInsertStatus) {
                    msg = "用户注册成功";
                    new JsonResult(isInsertStatus, msg);
                }
                return new JsonResult(isInsertStatus, "用户注册失败", loginError.getOther());
            }
        }
        return new JsonResult(false, "用户添加失败");
    }


    @ResponseBody
    @RequestMapping(value = "userLogin")
    public JsonResult<String> userSignInByNameAndPassword(@RequestBody UserDO userDO) {
        if (userDO.getUserName() == null || userDO.getUserPassword() == null) {
            return new JsonResult(false, "用户名或者密码为空");
        }

        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken uToken = new UsernamePasswordToken(userDO.getUserName(), userDO.getUserPassword());
        try {
            userSubject.login(uToken);
        } catch (UnknownAccountException e) {
            return new JsonResult(false, "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return new JsonResult(false, "用户密码不正确");
        } catch (LockedAccountException e) {
            return new JsonResult(false, "用户被锁");
        } catch (AuthenticationException e) {
            return new JsonResult(false, "其他错误");
        }
        List<UserDO> userBeans = userService.getUsersByPageIndex(userDO);
        if (0 != userBeans.size()) {
            UserDO userBean = userBeans.get(0);
            if (0 == userBean.getMailValid()) {
                return new JsonResult(false, "用户邮箱没有验证", userErrorCode.getMailValidError());
            }
        }

        return new JsonResult(true, "用户登录成功");
    }

    @ResponseBody
    @RequestMapping(value = "sendEmailCode")
    public JsonResult<Boolean> sendEmailValidCode(@RequestBody UserDO userDO) {
        List<UserDO> userDOList = userService.getUsersByPageIndex(userDO);
        if (userDOList.size() > 1) {
            return new JsonResult(false, "用户已经存在", loginError.getAccount());
        }
        UserDO userDO1 = userDOList.get(0);
        int emailCode = SystemUtils.getRandomNumber(1, 999999);
        userDO.setEmailCode(emailCode);
        userDO.setId(userDO1.getId());
        List<UserDO> userDOS = new ArrayList<>();
        userDOS.add(userDO);
        Boolean isStatus = userService.updateUserByUserInfo(userDOS);
        EmailUtils.emailUrl = userDO.getUserMail();
        EmailUtils.subjectTitle = "验证";
        EmailUtils.subjectContent = "" + emailCode;
        EmailUtils.sendEmail();
        return new JsonResult(isStatus, "发送成功", "0");
    }


    @ResponseBody
    @RequestMapping("userLoginOut")
    public JsonResult userSignOut() {
        JsonResult<String> jsonResult = new JsonResult();
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        jsonResult.setSuccess(true);
        jsonResult.setResult("注销成功");
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("validCode")
    public JsonResult validCode(@RequestBody UserDO userDO) {
        List<UserDO> userDOList = userService.getUsersByPageIndex(userDO);
        if (0 != userDOList.size()) {
            UserDO userData = userDOList.get(0);
            if (userData.getEmailCode().equals(userDO.getEmailCode())) {
                userData.setMailValid(1);
                List<UserDO> userDOS = new ArrayList<>();
                userDOS.add(userData);
                userService.updateUserByUserInfo(userDOS);
                return new JsonResult(true, "验证通过");
            } else {
                new JsonResult(false, "验证失败", loginError.getEmailValid());
            }
        }
        return new JsonResult(false, "验证失败", loginError.getEmailValid());
    }
}
