package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.resource.WXShare;
import com.rd.cloudcounter.service.WeChatService;
import com.rd.cloudcounter.utils.JsonUtils;
import com.rd.cloudcounter.utils.RDJSONResult;
import com.rd.cloudcounter.utils.WeChatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

/**
 * @author
 * @create 2020-12-10-10:26
 */

@Api(value = "微信分享接口",tags = {"微信分享相关的接口"})
@RestController
@RequestMapping("wechat")
public class AppWeChatController {

    @Autowired
    private WeChatService weChatService;


    @ApiOperation(value = "微信分享接口验证",notes = "微信分享接口验证",httpMethod = "GET")
    @GetMapping("/initJSSDKConfig")
    public RDJSONResult initJSSDKConfig(
            @ApiParam(name = "url",value = "分享地址",required = true)
            @RequestParam  String url)
    {

        if (StringUtils.isBlank(url)){
            return  RDJSONResult.errorMsg("url地址不能为空");
        }

        Map map = weChatService.initJSSDKConfig(url);

//        String reslut =  JsonUtils.objectToJson(map);
        return  RDJSONResult.ok(map);
    }


}
