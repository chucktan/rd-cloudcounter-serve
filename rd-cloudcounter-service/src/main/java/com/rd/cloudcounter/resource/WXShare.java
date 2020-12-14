package com.rd.cloudcounter.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author
 * @create 2020-12-09-15:44
 */
@Component
@ConfigurationProperties(prefix = "wxshare")//前缀
@PropertySource("classpath:wxshare-dev.properties")
public class WXShare {
    private  String appId;
    private  String appSecret;
    private  String jssdkAccesstokenUrl;
    private  String jssdkGetticketUrl;
    private  String userAuthorizeGetcodeUrl;
    private  String userAuthorizeAccesstokenUrl;
    private  String userAuthorizeGetuserinfoUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getJssdkAccesstokenUrl() {
        return jssdkAccesstokenUrl;
    }

    public void setJssdkAccesstokenUrl(String jssdkAccesstokenUrl) {
        this.jssdkAccesstokenUrl = jssdkAccesstokenUrl;
    }

    public String getJssdkGetticketUrl() {
        return jssdkGetticketUrl;
    }

    public void setJssdkGetticketUrl(String jssdkGetticketUrl) {
        this.jssdkGetticketUrl = jssdkGetticketUrl;
    }

    public String getUserAuthorizeGetcodeUrl() {
        return userAuthorizeGetcodeUrl;
    }

    public void setUserAuthorizeGetcodeUrl(String userAuthorizeGetcodeUrl) {
        this.userAuthorizeGetcodeUrl = userAuthorizeGetcodeUrl;
    }

    public String getUserAuthorizeAccesstokenUrl() {
        return userAuthorizeAccesstokenUrl;
    }

    public void setUserAuthorizeAccesstokenUrl(String userAuthorizeAccesstokenUrl) {
        this.userAuthorizeAccesstokenUrl = userAuthorizeAccesstokenUrl;
    }

    public String getUserAuthorizeGetuserinfoUrl() {
        return userAuthorizeGetuserinfoUrl;
    }

    public void setUserAuthorizeGetuserinfoUrl(String userAuthorizeGetuserinfoUrl) {
        this.userAuthorizeGetuserinfoUrl = userAuthorizeGetuserinfoUrl;
    }
}
