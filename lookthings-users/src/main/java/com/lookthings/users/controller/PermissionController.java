package com.lookthings.users.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.PermissionDO;
import com.lookthings.users.service.PermissionService;
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
@RequestMapping("permissionModule")
public class PermissionController {
    private static Logger log = Logger.getLogger(PermissionController.class);

    @Resource
    private PermissionService permissionService;


    /**
     * Gets permissions.
     *
     * @param permisId       the permis id
     * @param permissionName the permission name
     * @param pageNo         the page no
     * @param pageSize       the page size
     * @return the permissions
     */
    @ResponseBody
    @RequestMapping("/getPermissions")
    public JsonResult<PageInfo<PermissionDO>> getPermissions(String permisId, String permissionName, Integer pageNo, Integer pageSize) {
        JsonResult<PageInfo<PermissionDO>> jsonResult = new JsonResult();
        PermissionDO permissionDO = new PermissionDO();
        if (permisId != null) {
            permissionDO.setId(new Integer(permisId));
        }
        if (permissionName != null) {
            permissionDO.setPermissionName(permissionName);
        }
        log.debug("[permissionDO] [permissionDO]" + permissionDO.toString());
        jsonResult.setSuccess(true);
        jsonResult.setResult(permissionService.getPermissionByPageIndex(permissionDO, pageNo, pageSize));
        return jsonResult;
    }

    /**
     * Insert permission batch json result.
     *
     * @param permissionDOS the permission dos
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/insertPermissionBatch")
    public JsonResult<Boolean> insertPermissionBatch(String permissionDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (permissionDOS == null) {
            return jsonResult;
        }
        List<PermissionDO> permissionList = JSONArray.parseArray(permissionDOS, PermissionDO.class);
        Boolean isSuccess = permissionService.insertPermissionByPermissionInfo(permissionList);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }


    /**
     * Update permission batch json result.
     *
     * @param permissionDOS the permission dos
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/updatePermissionBatch")
    public JsonResult<Boolean> updatePermissionBatch(String permissionDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (permissionDOS == null) {
            return jsonResult;
        }
        List<PermissionDO> permissionList = JSONArray.parseArray(permissionDOS, PermissionDO.class);
        Boolean isSuccess = permissionService.updatePermissionByPermissionInfo(permissionList);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }

    /**
     * Delete permission batch json result.
     *
     * @param permissionDOS the permission dos
     * @return the json result
     */
    @ResponseBody
    @RequestMapping("/deletePermissionBatch")
    public JsonResult<Boolean> deletePermissionBatch(String permissionDOS) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        if (permissionDOS == null) {
            return jsonResult;
        }
        List<String> permissionIds = JSONArray.parseArray(permissionDOS, String.class);
        List<Integer> permissionIdInt = new ArrayList<>();
        if (permissionIds.size() == 0) {
            jsonResult.setSuccess(false);
            jsonResult.setResult(false);
            return jsonResult;
        }
        for (String Item : permissionIds) {
            permissionIdInt.add(Integer.parseInt(Item));
        }

        Boolean isSuccess = permissionService.deletePermissionByPermissionInfo(permissionIdInt);
        jsonResult.setSuccess(isSuccess);
        jsonResult.setResult(isSuccess);
        return jsonResult;
    }


}
