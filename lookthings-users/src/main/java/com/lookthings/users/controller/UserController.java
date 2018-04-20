package com.lookthings.users.controller;

import com.github.pagehelper.PageInfo;
import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @ResponseBody
    @RequestMapping("/insertUserBatch")
    public JsonResult<String> InsertUserBatch(@RequestBody List<UserDO> userDOS) {
        JsonResult<String> jsonResult = new JsonResult();
        Boolean isSuccess = userService.insertUserByUserInfo(userDOS);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult("");
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/updateUserBatch")
    public JsonResult<String> updateUserBatch(@RequestBody List<UserDO> userDOS) {
        JsonResult<String> jsonResult = new JsonResult();
        Boolean isSuccess = userService.updateUserByUserInfo(userDOS);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult("");
        return jsonResult;
    }


}
