package com.lookthings.users.controller;

import com.alibaba.fastjson.JSONArray;
import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.AssociatedRolePermissionDO;
import com.lookthings.users.model.PermissionDO;
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

    @ResponseBody
    @RequestMapping("/getPermissionByRoleId")
    public JsonResult<List<PermissionDO>> getPermissionByRoleId(Integer roleId) {
        List<PermissionDO> permissionDOS = associatedRolePermsService.getPermissionByRoleId(roleId);
        return new JsonResult(true, permissionDOS);
    }

    @ResponseBody
    @RequestMapping("/insertRolePermisLink")
    public JsonResult<List> insertRolePermsLink(String permissionList) {
        if (permissionList == null) {
            return new JsonResult(false, false);
        }
        List<AssociatedRolePermissionDO> associatedRolePermissionDOS = JSONArray.parseArray(permissionList, AssociatedRolePermissionDO.class);
        AssociatedRolePermissionDO associatedRolePermissionDO = associatedRolePermissionDOS.get(0);
        if (associatedRolePermissionDO.getRoleId() != 0 && associatedRolePermissionDO.getRoleId() != null) {
            associatedRolePermsService.deleteRolePermsByRoleId(associatedRolePermissionDO.getRoleId());
        }
        Boolean isStatus = associatedRolePermsService.insertRolePermsLink(associatedRolePermissionDOS);
        return new JsonResult(isStatus, isStatus);
    }


}
