package com.rd.cloudcounter.service;

import java.util.Map;

/**
 * @author
 * @create 2020-12-09-15:48
 */
public interface WeChatService {

    /**
     * 微信API
     * @param url
     * @return
     */
    public Map initJSSDKConfig(String url);
}
