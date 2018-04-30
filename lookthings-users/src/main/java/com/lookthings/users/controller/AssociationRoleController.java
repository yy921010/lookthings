package com.lookthings.users.controller;

import com.lookthings.core.json.JsonResult;
import com.lookthings.users.model.AssociatedRolePermissionDO;
import com.lookthings.users.service.AssociatedRolePermsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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


    @ResponseBody
    @RequestMapping("/insertRolePermisLink")
    public JsonResult<Boolean> insertRolePermsLink(AssociatedRolePermissionDO associatedRolePermissionDO) {
        JsonResult<Boolean> jsonResult = new JsonResult();
        Boolean isInsert = false;//associatedRolePermsService.insertRolePermsLink(associatedRolePermissionDO);
        jsonResult.setSuccess(isInsert);
        jsonResult.setResult(isInsert);
        return jsonResult;
    }


}
