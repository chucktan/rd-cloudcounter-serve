package com.rd.cloudcounter.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

/**
 * 微信JSSDKapi接口
 * @author
 * @create 2020-12-09-11:01
 */
public class WeChatUtil {

    public  static  final  String TOKEN = "rdbank"; //开发者自行定义Tooken

    /**
     * 微信分享接口1-获取access_token
     * @param jssdkAccesstokenUrl
     * @param appId
     * @param appSecret
     * @return
     */
    public  static  String getJSSDKAccessToken(String jssdkAccesstokenUrl,String appId,String appSecret)
    {
        String token = null;
        //1.读取缓存

        //2.重新读取
        String url = jssdkAccesstokenUrl.replaceAll("APPID",appId).replaceAll("APPSECRET",appSecret);
        String json = postRequestForWeiXinService(url);
        //Todo这个也许要改
        Map map = JsonUtils.jsonToPojo(json,Map.class);
        if (map != null){
            token = (String) map.get("access_token");
        }
        //3.缓存存储

        return token;
    }


    /**
     * 微信分享接口2-获取jsapi_ticket
     * @param jssdkGetticketUrl
     * @param accessToken
     * @return
     */
    public  static  String getJssdkGetticket(String jssdkGetticketUrl,String accessToken){
        String jsapi_ticket = null;

        //1.读取缓存

        //2.重新读取
        String url = jssdkGetticketUrl.replaceAll("ACCESS_TOKEN", accessToken);
        String json = postRequestForWeiXinService(url);
        //Todo这个也许要改
        Map map = JsonUtils.jsonToPojo(json,Map.class);
        if (map != null){
            jsapi_ticket = (String) map.get("ticket");
        }

        //3.存入缓存

        return  jsapi_ticket;

    }

    /**
     * 验证接口配置
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */

    public static boolean checkSignature(String signature, String timestamp, String nonce) throws  Exception {
        // 1.定义数组存放tooken，timestamp,nonce
        String[] arr = { TOKEN, timestamp, nonce };
        // 2.对数组进行排序
        Arrays.sort(arr);
        // 3.生成字符串
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        // 4.sha1加密,网上均有现成代码
        String temp = SHA1(sb.toString());
        // 5.将加密后的字符串，与微信传来的加密签名比较，返回结果
        return temp.equals(signature);

    }

    /**
     * 用户接入接口1-获取code
     * @param userAuthorizeCodeUrl
     * @param appId
     * @param redirectUrl
     * @return
     */
    public static String getUserAuthorizeCode(String userAuthorizeCodeUrl,String appId,String redirectUrl)
    {
        String code = null;
        //TODO 1.urlEncode(redirectUrl) 必须
            String encodeUrl = redirectUrl;
        //获取信息
        String url = userAuthorizeCodeUrl.replaceAll("APPID",appId).replaceAll("REDIRECT_URL",encodeUrl);
        String json = postRequestForWeiXinService(url);

        Map map = JsonUtils.jsonToPojo(json,Map.class);
        if (map != null){
            code = (String) map.get("code");
        }
        return  code;
    }

    /**
     * 用户接入接口2-获取accessToken,userOpenId
     * @param userAuthorizeAccessCodeUrl
     * @param appId
     * @param appsecret
     * @param code
     * @return
     */
    public static String getUserAuthorizeAccessToken(String userAuthorizeAccessCodeUrl,String appId,String appsecret,String code)
    {
//        String accessToken = null;
//        String openId  = null;
        //获取信息
        String url = userAuthorizeAccessCodeUrl.replaceAll("APPID",appId).replaceAll("SECRET",appsecret).replaceAll("CODE",code);
        String json = postRequestForWeiXinService(url);

//        Map map = JsonUtils.jsonToPojo(json,Map.class);
//        if (map != null){
//            accessToken = (String) map.get("access_token");
//            openId =  (String) map.get("openid");
//        }
        return  json;
    }

    /**
     *用户接入接口4-获取用户信息
     * @param userAuthorizeUserInfoUrl
     * @param openId
     * @return
     */
    public static String getUserAuthorizeUserInfo(String userAuthorizeUserInfoUrl,String accessToken,String openId){

        //获取信息
        String url = userAuthorizeUserInfoUrl.replaceAll("ACCESS_TOKEN",accessToken).replaceAll("OPENID",openId);
        String json = postRequestForWeiXinService(url);

        return  json;
    }



    /**
     *  构建分享链接的签名
     * @param ticket 根据accessToken生成的JssdkGetticket
     * @param timestamp 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
     * @param nonceStr  随机字符串
     * @param url  当前网页的URL
     * @return
     * @throws Exception
     */
    public  static  String buildJSSDKSignature(String ticket,String timestamp,String nonceStr,String url) throws  Exception{
        String orderedString = "jsapi_ticket=" + ticket +"&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;

        return  SHA1(orderedString);
    }


    /**
     * 调用微信接口
     * @param getAccessTokenUrl
     * @return
     */
    private  static  String postRequestForWeiXinService(String getAccessTokenUrl){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> postForEntity =  restTemplate.postForEntity(getAccessTokenUrl,null,String.class);
        String json =  postForEntity.getBody();
        return  json;
    }


    /**
     *sha1 加密JSSDK微信配置参数获取签名
     * @param orderedString
     * @return
     * @throws Exception
     */
    private   static  String SHA1(String orderedString) throws  Exception{
        String ciphertext = null;
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest =  md.digest(orderedString.getBytes());
        //可替换
        ciphertext = DatatypeConverter.printHexBinary(digest);
        return  ciphertext.toLowerCase();
    }

    /**
     *  将字节数组转换为十六进制字符串
     * @param byteArray
     * @return
     */
    private  static  String  byteToStr(byte[] byteArray){
        String strDigest = "";
        for (int i = 0;i < byteArray.length;i++){
            strDigest+= byteToHexStr(byteArray[i]);
        }
        return  strDigest;
    }


    /**
     * 将字节转换为十六进制字符串
     * @param mByte
     * @return
     */
    private  static  String byteToHexStr(byte mByte){
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4)& 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return  s;
    }


    /**
     *将map对象转为json
     * @param map
     * @return
     */
    private   static  String mapToJson(Map map){
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return  json;
    }

    /**
     * 将json对象转为map
     * @param json
     * @return
     */
    private   static  Map jsonToMap(String json){
        Gson gson = new Gson();
        Map map = gson.fromJson(json,new TypeToken<Map>(){}.getType());
        return  map;
    }

}
