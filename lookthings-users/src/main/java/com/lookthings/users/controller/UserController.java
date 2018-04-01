package com.lookthings.users.controller;

import com.lookthings.core.utils.SystemUtils;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.PermissionService;
import com.lookthings.users.service.RoleService;
import com.lookthings.users.service.UserService;
import com.lookthings.users.service.impl.CommonConfig;
import com.lookthings.users.vo.JsonResult;
import com.lookthings.users.vo.RolePermsLinkVO;
import com.lookthings.users.vo.UserSuccessVO;
import org.apache.log4j.Logger;
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
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/1/20.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("user")
public class UserController implements BaseOperationController<UserDO> {
    private static Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    @Resource
    private CommonConfig commonConfig;

    @Override
    @ResponseBody
    @RequestMapping("/getUser")
    public JsonResult<List<UserDO>> select(String userId) {
        JsonResult<List<UserDO>> jsonResult = new JsonResult<List<UserDO>>();
        UserDO userDO = new UserDO();
        if (userId != null) {
            userDO.setId(new Integer(userId));
        }
        List<UserDO> userDOList = userService.findListUser(userDO);
        jsonResult.setSuccess(true);
        jsonResult.setResult(userDOList);
        return jsonResult;
    }

    @Override
    @ResponseBody
    @RequestMapping("/addUser")
    public JsonResult<String> insert(@RequestBody UserDO userDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        List<UserDO> userDOList = userService.findListUser(userDO);
        Boolean isAddUser = false;
        if (userDO != null) {
            ByteSource salt = ByteSource.Util.bytes(commonConfig.getIsaKey());
            SimpleHash simpleHashPassword = new SimpleHash("md5", userDO.getUserPassword(), salt, 2);
            userDO.setUserPassword(simpleHashPassword.toString());
        }
        if (userDOList.size() > 0) {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户已经存在");
            return jsonResult;
        } else if (userService.insertUser(userDO)) {
            isAddUser = true;
            jsonResult.setSuccess(true);
            jsonResult.setResult("用户添加成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户添加失败");
        }
        log.debug("[insert] [isAddUser]: " + isAddUser);
        return jsonResult;
    }

    @Override
    @ResponseBody
    @RequestMapping("/updateUser")
    public JsonResult<String> update(@RequestBody UserDO userDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Boolean isUpdateUser = userService.updateUser(userDO);
        if (isUpdateUser) {
            jsonResult.setSuccess(true);
            jsonResult.setResult("用户更新成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户更新失败");
        }
        log.debug("[update] [isUpdateUser]: " + isUpdateUser);
        return jsonResult;
    }

    @Override
    @ResponseBody
    @RequestMapping("/deleteUser")
    public JsonResult<String> delete(@RequestBody UserDO userDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Boolean isDeleteUser = userService.deleteUser(userDO);
        if (isDeleteUser) {
            jsonResult.setSuccess(true);
            jsonResult.setResult("用户删除成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户删除失败");
        }
        log.debug("[delete] [isDeleteUser]: " + isDeleteUser);
        return jsonResult;
    }

    /**
     * 用户登录
     *
     * @param userDO the user do
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "/userLogin")
    public JsonResult userSignInByNameAndPassword(@RequestBody UserDO userDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        if (userDO.getUserName() == null || userDO.getUserPassword() == null) {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户名或者密码");
            return jsonResult;
        }
        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken uToken = new UsernamePasswordToken(userDO.getUserName(), userDO.getUserPassword());
        try {
            userSubject.login(uToken);
        } catch (UnknownAccountException e) {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户名不存在");
            return jsonResult;
        } catch (IncorrectCredentialsException e) {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户密码不正确");
            return jsonResult;
        } catch (LockedAccountException e) {
            jsonResult.setSuccess(false);
            jsonResult.setError("用户被锁");
            return jsonResult;
        } catch (AuthenticationException e) {
            jsonResult.setSuccess(false);
            jsonResult.setError("其他错误");
            return jsonResult;
        }
        // 封装用户信息
        UserSuccessVO userSuccessVO = new UserSuccessVO();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userSuccessVO.setUserName(userDO.getUserName());
        userSuccessVO.setSysDate(df.format(new Date()));
        JsonResult<UserSuccessVO> objectJsonResult = new JsonResult<UserSuccessVO>();
        objectJsonResult.setSuccess(true);
        objectJsonResult.setResult(userSuccessVO);
        return objectJsonResult;
    }

    /**
     * 用户注销
     *
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/userLoginOut")
    public JsonResult userSignOut() {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        jsonResult.setSuccess(true);
        jsonResult.setResult("注销成功");
        return jsonResult;
    }

    /**
     * 获得所有用户角色权限的所有个数
     *
     * @param request the request
     * @return the object
     */
    @ResponseBody
    @RequestMapping("/userNormalInfo")
    public JsonResult userRolePermsCounts(HttpServletRequest request) {
        JsonResult<UserSuccessVO> jsonResult = new JsonResult<UserSuccessVO>();
        List<Integer> userRolePerms = new ArrayList<Integer>();
        UserSuccessVO userSuccessVO = new UserSuccessVO();
        jsonResult.setSuccess(true);
        int userCount = userService.userCount();
        int roleCount = roleService.roleCount();
        int permissionCount = permissionService.permissionCount();
        log.debug("[userRolePermsCounts] [userCount]: " + userCount);
        userRolePerms.add(userCount);
        log.debug("[userRolePermsCounts] [roleCount]: " + roleCount);
        userRolePerms.add(roleCount);
        log.debug("[userRolePermsCounts] [permissionCount]: " + permissionCount);
        userRolePerms.add(permissionCount);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userSuccessVO.setSysDate(df.format(new Date()));
        log.debug("[userRolePermsCounts] [setSysDate]: " + df.format(new Date()));
        userSuccessVO.setIpAddress(SystemUtils.getSystemIpAddress(request));
        userSuccessVO.setUserRolePermsCounts(userRolePerms);
        jsonResult.setResult(userSuccessVO);
        return jsonResult;
    }

    /**
     * Gets role name by user name.
     *
     * @param userName the user name
     * @return the role name by user name
     */
    @ResponseBody
    @RequestMapping("/roleNameByUserName")
    public JsonResult<Set<String>> getRoleNameByUserName(String userName) {
        Set<String> rolesStringSet = userService.getRolesByUserName(userName);
        JsonResult<Set<String>> jsonResult = new JsonResult<Set<String>>();
        jsonResult.setSuccess(true);
        jsonResult.setResult(rolesStringSet);
        return jsonResult;
    }

    /**
     * Gets role name by user name.
     *
     * @param roleId the role id
     * @return the role name by user name
     */
    @ResponseBody
    @RequestMapping("/getPermissionByRoleId")
    public JsonResult<List<PermissionDO>> getPermissionByRoleId(Integer roleId) {
        List<PermissionDO> permissionDOList = userService.getPermissionByRoleId(roleId);
        JsonResult<List<PermissionDO>> jsonResult = new JsonResult<List<PermissionDO>>();
        jsonResult.setSuccess(true);
        jsonResult.setResult(permissionDOList);
        return jsonResult;
    }

    /**
     * 更新权限
     *
     * @param rolePermsLinkVO the role perms link do
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/updatePermissionLink")
    public JsonResult<String> updatePermissionLink(@RequestBody RolePermsLinkVO rolePermsLinkVO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        userService.deleteRolePermsByRoleId(rolePermsLinkVO.getRoleId());
        Boolean isInsertRolePerms;
        isInsertRolePerms = userService.insertRolePermsLink(rolePermsLinkVO);
        jsonResult.setSuccess(isInsertRolePerms);
        jsonResult.setResult(isInsertRolePerms ? "添加成功" : "添加失败");
        return jsonResult;
    }
}
