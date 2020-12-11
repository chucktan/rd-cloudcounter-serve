package com.rd.cloudcounter.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author
 * @create 2020-11-20-15:01
 */
@ApiModel(value = "用户对象Bo",description = "从客户端，由微信传入的数据封装在此entity中")
public class UserInfoBo {


    @ApiModelProperty(value = "用户名",name = "userName",example = "珣",required = true)
    private String userName;


    @ApiModelProperty(value = "用户密码",name = "password",example = "132456",required = true)
    private String password;

    @ApiModelProperty(value = "确认密码",name = "confirmPassword",example = "132456",required = true)
    private  String confirmPassword;


    //TODO 微信获取用户头像的方法未知，须整改
//    @ApiModelProperty(value = "用户头像",name = "userImgUrl",example = "",required = true)
//    private String userImgUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
