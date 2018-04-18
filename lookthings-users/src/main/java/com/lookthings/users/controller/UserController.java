package com.lookthings.users.controller;

import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
@RequestMapping("user")
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/getUser")
    public JsonResult<List<UserDO>> select(String userId) {
        JsonResult<List<UserDO>> jsonResult = new JsonResult<List<UserDO>>();
        UserDO userDO = new UserDO();
        if (userId != null) {
            userDO.setId(new Integer(userId));
        }
        List<UserDO> userDOList = userService.getUsersByUserInfo(userDO);
        jsonResult.setSuccess(true);
        jsonResult.setResult(userDOList);
        return jsonResult;
    }
}
