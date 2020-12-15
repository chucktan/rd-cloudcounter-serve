package com.rd.cloudcounter.service;

import java.util.Map;

/**
 * @author
 * @create 2020-12-09-15:48
 */
public interface WeChatService {

    /**
     * 微信分享API
     * @param url
     * @return
     */
    public Map initJSSDKConfig(String url);

    /**
     * 微信网页授权,获取用户信息
     * @param code
     * @return
     */
    public String userAuthorize (String code);

    /**
     * 根据回调地址，获取网页授权地址
     *  @param redirectUrl
     * @return
     */
    public String getUserAuthorizeUrl(String redirectUrl);
}
