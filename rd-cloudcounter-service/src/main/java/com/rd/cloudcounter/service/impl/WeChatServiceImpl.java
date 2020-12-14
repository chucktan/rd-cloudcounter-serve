package com.rd.cloudcounter.service.impl;

import com.rd.cloudcounter.resource.WXShare;
import com.rd.cloudcounter.service.WeChatService;
import com.rd.cloudcounter.utils.JsonUtils;
import com.rd.cloudcounter.utils.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author
 * @create 2020-12-09-15:50
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    @Autowired
    private WXShare wxShare;


    /*
     1.先通过appId和appSecret参数请求指定微信地址 获取AccessToken
     2.在通过第一步中的AccessToken作为参数请求微信地址 获取jsapi_ticket临时票据(此处不考虑调用频率，使用者根据情况放入缓存或定时任务)
     3.通过第二步的JssdkGetticket和timestamp,nonceStr,url作为参数请求微信地址，获取签名signature
     4.将第三步获得的signature和jsapi_ticket,nonceStr,timestamp,url返回给前端，作为Config初始化验证的信息
    */
    @Override
    public Map initJSSDKConfig(String url) {
        Map<String,String> map = new HashMap<String,String>();

        try {
            //1.获取AccessToken
            String accessToken = WeChatUtil.getJSSDKAccessToken(wxShare.getJssdkAccesstokenUrl(),wxShare.getAppId(),wxShare.getAppSecret());

            //2.获取JssdkGetticket
            String jsapiTicket = WeChatUtil.getJssdkGetticket(wxShare.getJssdkGetticketUrl(),accessToken);

            //3.签名
            String timestamp = Long.toString(System.currentTimeMillis()/1000);
            String nonceStr = UUID.randomUUID().toString();
            String signature = WeChatUtil.buildJSSDKSignature(jsapiTicket,timestamp,nonceStr,url);

            map.put("url",url);
            map.put("jsapi_ticket",jsapiTicket);
            map.put("nonceStr",nonceStr);
            map.put("timestamp",timestamp);
            map.put("signature",signature);
            map.put("appId",wxShare.getAppId());

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return map;
    }


    @Override
    public String userAuthorize(String redirectUrl) {

        String jsonResult = null;

        try {
            //1.用户同意授权，获取code
            String code = WeChatUtil.getUserAuthorizeCode(wxShare.getUserAuthorizeGetcodeUrl(),wxShare.getAppId(),redirectUrl);
            //2.通过code换取网页授权access_token
            String accessCodeResult = WeChatUtil.getUserAuthorizeAccessToken(wxShare.getUserAuthorizeAccesstokenUrl(),wxShare.getAppId(),wxShare.getAppSecret(),code);

            Map accessCodeMap = JsonUtils.jsonToPojo(accessCodeResult,Map.class);
            if (accessCodeMap != null){
                String accessToken = (String) accessCodeMap.get("access_token");
                String  openId =  (String) accessCodeMap.get("openid");

                //3.拉取用户信息(需scope为 snsapi_userinfo)
                jsonResult =  WeChatUtil.getUserAuthorizeUserInfo(wxShare.getUserAuthorizeGetuserinfoUrl(),accessToken,openId);
            }


        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return jsonResult;

    }


}
