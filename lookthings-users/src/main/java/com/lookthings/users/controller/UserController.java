package com.lookthings.users.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fantasy on 2018/4/19.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("userModule")
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 根据用户参数进行用户的查询
     *
     * @param userId
     * @param userName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUsers")
    public JsonResult<PageInfo<UserDO>> getUsers(String userId, String userName, Integer pageNo, Integer pageSize) {
        JsonResult<PageInfo<UserDO>> jsonResult = new JsonResult();
        log.info("[getUsers][userId]" + userId);
        log.info("[getUsers][userName]" + userName);
        log.info("[getUsers][pageNo]" + pageNo);
        log.info("[getUsers][pageSize]" + pageNo);
        UserDO userDO = new UserDO();
        if (userId != null) {
            userDO.setId(new Integer(userId));
        }
        if (userName != null) {
            userDO.setUserName(userName);
        }
        jsonResult.setSuccess(true);
        jsonResult.setResult(userService.getUsersByPageIndex(userDO, pageNo, pageSize));
        return jsonResult;
    }

    /**
     * 批量插入用户数据
     *
     * @param userDOS
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertUserBatch")
    public JsonResult<Boolean> insertUserBatch(String userDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (userDOS == null) {
            return jsonResult;
        }
        List<UserDO> userList = JSONArray.parseArray(userDOS, UserDO.class);
        Boolean isSuccess = userService.insertUserByUserInfo(userList);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }

    /**
     * 批量更新用户
     *
     * @param userDOS
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUserBatch")
    public JsonResult<Boolean> updateUserBatch(String userDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (userDOS == null) {
            return jsonResult;
        }
        List<UserDO> userList = JSONArray.parseArray(userDOS, UserDO.class);
        Boolean isSuccess = userService.updateUserByUserInfo(userList);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }

    /**
     * 批量删除用户
     *
     * @param userDOS
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUserBatch")
    public JsonResult<Boolean> deleteUserBatch(String userDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (userDOS == null) {
            return jsonResult;
        }
        List<String> userIds = JSONArray.parseArray(userDOS, String.class);
        List<Integer> userIdsInt = new ArrayList<>();
        for (String Item : userIds) {
            userIdsInt.add(Integer.parseInt(Item));
        }
        Boolean isSuccess = userService.deleteUserByUserInfo(userIdsInt);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }
}
