package com.lookthings.users.controller;

import com.lookthings.users.model.RoleDO;
import com.lookthings.users.service.RoleService;
import com.lookthings.core.json.JsonResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fantasy on 2018/2/5.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("role")
public class RoleController implements BaseOperationController<RoleDO> {
    private static Logger log = Logger.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/getRole")
    public JsonResult<List<RoleDO>> select(String id) {
        JsonResult<List<RoleDO>> jsonResult = new JsonResult<List<RoleDO>>();
        RoleDO roleDO = new RoleDO();
        if (id != null) {
            roleDO.setId(Integer.parseInt(id));
            log.debug("[select] [rolesId]: " + id);
        }
        List<RoleDO> roleDOList = roleService.findListRole(roleDO);
        jsonResult.setSuccess(true);
        jsonResult.setResult(roleDOList);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/addRole")
    public JsonResult<String> insert(@RequestBody RoleDO roleDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        List<RoleDO> roleDOList = roleService.findListRole(roleDO);
        Boolean isRoles = false;
        if (roleDOList.size() > 0) {
            jsonResult.setError("角色已经存在");
            jsonResult.setSuccess(false);
        } else if (roleService.insertRole(roleDO)) {
            isRoles = true;
            jsonResult.setSuccess(true);
            jsonResult.setResult("角色添加成功");
        } else {
            isRoles = false;
            jsonResult.setSuccess(false);
            jsonResult.setError("角色添加失败");
        }
        log.debug("[insert] [isRoles]: " + isRoles);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/updateRole")
    public JsonResult<String> update(@RequestBody RoleDO roleDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Boolean isUpdateRole = roleService.updateRole(roleDO);
        if (isUpdateRole) {
            jsonResult.setSuccess(true);
            jsonResult.setResult("角色更新成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("角色更新失败");
        }
        log.debug("[update] [isUpdateRole]: " + isUpdateRole);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/deleteRole")
    public JsonResult<String> delete(@RequestBody RoleDO roleDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Boolean isDeleteRole = roleService.deleteRole(roleDO);
        if (isDeleteRole) {
            jsonResult.setSuccess(true);
            jsonResult.setResult("角色删除成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("角色删除失败");
        }
        log.debug("[delete] [isDeleteRole]: " + isDeleteRole);
        return jsonResult;
    }
}
