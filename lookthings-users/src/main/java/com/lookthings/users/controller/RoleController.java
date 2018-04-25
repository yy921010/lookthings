package com.lookthings.users.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.RoleDO;
import com.lookthings.users.service.RoleService;
import org.apache.log4j.Logger;
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
@RequestMapping("roleModule")
public class RoleController {
    private static Logger log = Logger.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    /**
     * Gets role.
     *
     * @param roleId   the role id
     * @param roleName the role name
     * @param pageNo   the page no
     * @param pageSize the page size
     * @return the role
     */
    @ResponseBody
    @RequestMapping("/getRoles")
    public JsonResult<PageInfo<RoleDO>> getRole(String roleId, String roleName, Integer pageNo, Integer pageSize) {
        JsonResult<PageInfo<RoleDO>> jsonResult = new JsonResult();
        RoleDO roleDO = new RoleDO();
        if (roleId != null) {
            roleDO.setId(Integer.parseInt(roleId));
        }
        if (roleName != null) {
            roleDO.setRoleName(roleName);
        }
        log.debug("[getRole] [roleDO]" + roleDO.toString());
        jsonResult.setSuccess(true);
        jsonResult.setResult(roleService.getRoleByPageIndex(roleDO, pageNo, pageSize));
        return jsonResult;
    }

    /**
     * Insert role batch json result.
     *
     * @param roleDOS the role dos
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/insertRoleBatch")
    public JsonResult<Boolean> insertRoleBatch(String roleDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (roleDOS == null) {
            return jsonResult;
        }
        List<RoleDO> roleDOList = JSONArray.parseArray(roleDOS, RoleDO.class);
        log.debug("[insertRoleBatch] [roleDOList]" + roleDOList.toString());
        Boolean isSuccess = roleService.insertRoleByRoleInfo(roleDOList);
        jsonResult.setResult(isSuccess);
        jsonResult.setSuccess(isSuccess);
        return jsonResult;
    }

    /**
     * Update user batch json result.
     *
     * @param roleDOS the role dos
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/updateRoleBatch")
    public JsonResult<Boolean> updateRoleBatch(String roleDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (roleDOS == null) {
            return jsonResult;
        }
        List<RoleDO> roleDOList = JSONArray.parseArray(roleDOS, RoleDO.class);
        Boolean isSuccess = roleService.updateRoleByRoleInfo(roleDOList);
        log.debug("[updateRoleBatch] [roleDOList]" + roleDOList.toString());
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }

    /**
     * Delete user batch json result.
     *
     * @param roleDOS the role dos
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/deleteRoleBatch")
    public JsonResult<Boolean> deleteUserBatch(String roleDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (roleDOS == null) {
            return jsonResult;
        }
        List<String> roleIds = JSONArray.parseArray(roleDOS, String.class);
        List<Integer> roleIdsInt = new ArrayList<>();
        for (String Item : roleIds) {
            roleIdsInt.add(Integer.parseInt(Item));
        }
        Boolean isSuccess = roleService.deleteRoleByRoleInfo(roleIdsInt);
        log.debug("[deleteUserBatch] [roleIdsInt]" + roleIdsInt.toString());
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }


}
