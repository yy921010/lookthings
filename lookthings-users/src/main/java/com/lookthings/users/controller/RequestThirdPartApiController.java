package com.lookthings.users.controller;

import com.alibaba.fastjson.JSON;
import com.lookthings.core.utils.RegexUtils;
import com.lookthings.users.service.impl.CommonConfig;
import com.lookthings.core.json.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Fantasy on 2018/2/27.
 *
 * @author Fantasy
 */
@Controller
@RequestMapping("ThirdPartApi")
public class RequestThirdPartApiController {
    private final static String DOUBAN_STR = "douban";
    private final static String JU_HE = "juhe";
    @Resource
    private CommonConfig commonConfig;

    @ResponseBody
    @RequestMapping("/getResult")
    public JsonResult<String> getDatasByThirdPartApi(String thirdPartUrls) {
        Boolean isUrlStr = RegexUtils.checkURL(thirdPartUrls);
        JsonResult<String> jsonResult = new JsonResult<String>();
        RestTemplate restTemplate = new RestTemplate();
        if (isUrlStr) {
            String fullUrls = pushApiKeyForUrls(thirdPartUrls);

            String responseEntity = restTemplate.getForObject(fullUrls, String.class);
            JSON.parse(responseEntity);
            jsonResult.setResult(responseEntity);
        }
        return jsonResult;
    }

    private String pushApiKeyForUrls(String thirdPartUrls) {
        if (thirdPartUrls.contains(DOUBAN_STR)) {
            return thirdPartUrls + "?apikey=" + commonConfig.getDoubanKey();
        } else if (thirdPartUrls.contains(JU_HE)) {
            return thirdPartUrls + "?key=" + commonConfig.getJuheKey();
        } else {
            return thirdPartUrls;
        }
    }
}
