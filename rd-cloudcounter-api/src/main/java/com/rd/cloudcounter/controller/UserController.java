package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.UserInfoBo;
import com.rd.cloudcounter.service.UserService;
import com.rd.cloudcounter.utils.CookieUtils;
import com.rd.cloudcounter.utils.JsonUtils;
import com.rd.cloudcounter.utils.RDJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @create 2020-11-23-9:37
 */
@Api(value = "接入登录",tags = {"用于接入微信登录的相关接口"})
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //TODO 不太清楚微信的接入是什么情况，这里也要修改
    @ApiOperation(value = "用户登录接入",notes = "用户登录接入",httpMethod = "POST")
    @PostMapping("/login")
    public RDJSONResult login(
            @ApiParam(name = "userBo",value = "用户信息Bo",required = true)
            @RequestBody UserInfoBo userBo, HttpServletRequest request, HttpServletResponse response)
    throws  Exception{
        String userName = userBo.getUserName();

        //0.判断用户名不能为空
        if (StringUtils.isBlank(userName)){
            return RDJSONResult.errorMsg("用户名不能为空");
        }

        //1.实现登录
        //TODO：不能只用用户名登录，此处需修改
        UserInfo userResult = userService.queryUserForLogin(userName);

        if (userResult == null){
            return  RDJSONResult.errorMsg("用户不存在");
        }

        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(userResult),true);
        return RDJSONResult.ok(userResult);

    }

    @ApiOperation(value = "用户退出登录",notes = "用户退出登录",httpMethod = "POST")
    @PostMapping("/logout")
    public  RDJSONResult logout(
            @ApiParam(name = "userId",value = "用户ID",required = true)
            @RequestParam  String userId,HttpServletRequest request,HttpServletResponse response){
        //清楚用户信息相关的Cookie
        CookieUtils.deleteCookie(request,response,"user");

        return  RDJSONResult.ok();
    }

    private UserInfo setNullProperty(UserInfo userResult){

        userResult.setCreatedBy(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedBy(null);
        userResult.setUpdatedTime(null);

        return  userResult;

    }

}
