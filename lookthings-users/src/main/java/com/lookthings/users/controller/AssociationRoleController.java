package com.lookthings.users.controller;

import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.AssociatedRolePermissionDO;
import com.lookthings.users.model.UserDO;
import com.lookthings.users.service.AssociatedRolePermsService;
import com.lookthings.users.service.UserService;
import com.lookthings.users.vo.UserRoleLinkVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2018/4/24.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("associationModule")
public class AssociationRoleController {


    @Resource
    private AssociatedRolePermsService associatedRolePermsService;

    @Resource
    private UserService userService;


    @ResponseBody
    @RequestMapping("/insertRolePermisLink")
    public JsonResult<Boolean> insertRolePermsLink(AssociatedRolePermissionDO associatedRolePermissionDO) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        Boolean isInsert = false;//associatedRolePermsService.insertRolePermsLink(associatedRolePermissionDO);
        jsonResult.setSuccess(isInsert);
        jsonResult.setResult(isInsert);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/getRoleListByUserId")
    public JsonResult<List<UserRoleLinkVO>> getRoleListByUserId(Integer userId) {
        List<UserRoleLinkVO> roleDOS = associatedRolePermsService.getRolesByUserId(userId);
        return new JsonResult(true, roleDOS);
    }


    @ResponseBody
    @RequestMapping("/insertUserRoleLink")
    public JsonResult<Boolean> insertUserRoleLink(Integer userId, Integer roleId) {
        UserDO userDO = new UserDO();
        userDO.setId(userId);
        userDO.setRoleId(roleId);
        List<UserDO> userDOS = new ArrayList<>();
        userDOS.add(userDO);
        Boolean isStatus = userService.updateUserByUserInfo(userDOS);
        return new JsonResult(isStatus, isStatus);
    }


}
