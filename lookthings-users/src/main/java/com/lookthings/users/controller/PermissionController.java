package com.lookthings.users.controller;

import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.service.PermissionService;
import com.lookthings.core.json.JsonResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fantasy on 2018/2/7.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("permission")
public class PermissionController implements BaseOperationController<PermissionDO> {
    private static Logger log = Logger.getLogger(PermissionController.class);
    @Resource
    private PermissionService permissionService;

    @ResponseBody
    @RequestMapping("/getPerm")
    public JsonResult<List<PermissionDO>> select(String id) {
        JsonResult<List<PermissionDO>> jsonResult = new JsonResult<List<PermissionDO>>();
        PermissionDO permissionDO = new PermissionDO();
        if (id != null) {
            permissionDO.setId(Integer.parseInt(id));
            log.debug("[select] [permId]: " + id);
        }
        List<PermissionDO> roleDOList = permissionService.findListPermission(permissionDO);
        jsonResult.setSuccess(true);
        jsonResult.setResult(roleDOList);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/addPerm")
    public JsonResult<String> insert(@RequestBody PermissionDO permissionDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        List<PermissionDO> permissionDOList = permissionService.findListPermission(permissionDO);
        Boolean isPermission = false;
        if (permissionDOList.size() > 0) {
            jsonResult.setError("权限已经存在");
            jsonResult.setSuccess(false);
        } else if (permissionService.insertPermission(permissionDO)) {
            isPermission = true;
            jsonResult.setSuccess(true);
            jsonResult.setResult("权限添加成功");
        } else {
            isPermission = false;
            jsonResult.setSuccess(false);
            jsonResult.setError("权限添加失败");
        }
        log.debug("[insert] [isPermission]: " + isPermission);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/updatePerm")
    public JsonResult<String> update(@RequestBody PermissionDO permissionDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Boolean isUpdatePermission = permissionService.updatePermission(permissionDO);
        if (isUpdatePermission) {
            jsonResult.setSuccess(true);
            jsonResult.setResult("权限更新成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("权限更新失败");
        }
        log.debug("[update] [isUpdatePermission]: " + isUpdatePermission);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/deletePerm")
    public JsonResult<String> delete(@RequestBody PermissionDO permissionDO) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        Boolean isDeletePermission = permissionService.deletePermission(permissionDO);
        if (isDeletePermission) {
            jsonResult.setSuccess(true);
            jsonResult.setResult("权限删除成功");
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setError("权限删除失败");
        }
        log.debug("[delete] [isDeletePermission]: " + isDeletePermission);
        return jsonResult;
    }
}
