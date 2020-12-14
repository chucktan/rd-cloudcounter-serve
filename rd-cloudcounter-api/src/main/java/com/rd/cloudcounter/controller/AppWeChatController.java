package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.UserInfoBo;
import com.rd.cloudcounter.resource.WXShare;
import com.rd.cloudcounter.service.UserService;
import com.rd.cloudcounter.service.WeChatService;
import com.rd.cloudcounter.utils.CookieUtils;
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


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private UserService userService;


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


    @ApiOperation(value = "微信接口验证",notes = "微信接口验证",httpMethod = "GET")
    @GetMapping("/dispatCherServlet")
    public RDJSONResult dispatCherServlet(
            @ApiParam(name = "signature",value = "微信加密签名",required = true)
            @RequestParam  String signature,
            @ApiParam(name = "timestamp",value = "时间戳",required = true)
            String timestamp ,
            @ApiParam(name = "nonce",value = "随机数",required = true)
            String nonce,
            @ApiParam(name = "echostr",value = "随机字符串",required = true)
            String echostr)
    {
        if (StringUtils.isAnyBlank(signature,timestamp,nonce,echostr)){
            return RDJSONResult.errorMsg("微信加密签名|时间戳|随机数|随机字符串 不能为空");
        }

        try {
            if (!WeChatUtil.checkSignature(signature,timestamp,nonce)){
                return  RDJSONResult.errorMsg("接口验证错误");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return RDJSONResult.ok(echostr);

    }


    @ApiOperation(value = "微信用户授权",notes = "微信用户授权",httpMethod = "GET")
    @GetMapping("/userAuthor")
    public RDJSONResult userAuthor(
            @ApiParam(name = "redirectUrl",value = "微信加密签名",required = true)
            @RequestParam  String redirectUrl, HttpServletRequest request, HttpServletResponse response
            )
    {
        if (StringUtils.isBlank(redirectUrl)){
            return  RDJSONResult.errorMsg("回调地址不能为空");
        }

        //1.获取用户信息
         String  userInfoJson   = weChatService.userAuthorize(redirectUrl);

        Map userInfoMap = JsonUtils.jsonToPojo(userInfoJson,Map.class);
        if (userInfoMap != null){
            String openID = (String) userInfoMap.get("openid");
            String userName = (String) userInfoMap.get("nickname");
            String userImgUrl = (String) userInfoMap.get("headimgurl");

            //2.根据openID 判断是否已经授权过，如果没有授权,自动注册用户

            UserInfo userResult =  userService.queryUserByOpenId(openID);

            if (userResult == null){
                //2.1注册用户
                UserInfoBo userInfoBo = new UserInfoBo();
                userInfoBo.setOpenID(openID);
                userInfoBo.setUserName(userName);
                userInfoBo.setUserImgUrl(userImgUrl);

                userResult = userService.createUser(userInfoBo);
            }

            setNullProperty(userResult,userName,userImgUrl);
            //3. 已经授权过，自动登录
            CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(userResult),true);

            return  RDJSONResult.ok(userResult);

        }else{
            return  RDJSONResult.errorMsg("用户授权接入出错");
        }
    }


    private UserInfo setNullProperty(UserInfo userResult,String userName,String imgUrl){

        userResult.setUsername(userName);
        userResult.setUserimgurl(imgUrl);
        userResult.setPassword(null);
        userResult.setCreatedBy(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedBy(null);
        userResult.setUpdatedTime(null);

        return  userResult;

    }

}
