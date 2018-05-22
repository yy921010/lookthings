package com.lookthings.users.controller;

import com.lookthings.core.json.JsonResult;
import com.lookthings.core.service.impl.CommonConfig;
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


    @ResponseBody
    @RequestMapping(value = "/userSignUp")
    public JsonResult<String> userSignUp(@RequestBody UserDO userDO) {
        Boolean isInsertStatus;
        if (null != userDO.getUserName()) {
            List<UserDO> userBeans = userService.getUsersByPageIndex(userDO);
            List<UserDO> userDOList = new ArrayList<>();
            if (0 != userBeans.size()) {
                return new JsonResult(false, "用户已经存在");
            } else {
                ByteSource salt = ByteSource.Util.bytes(commonConfig.getIsaKey());
                SimpleHash simpleHashPassword = new SimpleHash("md5", userDO.getUserPassword(), salt, 2);
                userDO.setUserPassword(simpleHashPassword.toString());
                userDOList.add(userDO);
                isInsertStatus = userService.insertUserByUserInfo(userDOList);
                return new JsonResult(isInsertStatus, isInsertStatus ? "用户添加成功" : "用户添加失败");
            }
        }
        return new JsonResult(false, "用户添加失败");
    }


    @ResponseBody
    @RequestMapping(value = "/userLogin")
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
        return new JsonResult(true, "用户登录成功");
    }

    @ResponseBody
    @RequestMapping("/userLoginOut")
    public JsonResult userSignOut() {
        JsonResult<String> jsonResult = new JsonResult();
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        jsonResult.setSuccess(true);
        jsonResult.setResult("注销成功");
        return jsonResult;
    }
}
