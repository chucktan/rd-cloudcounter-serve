package com.rd.cloudcounter.service;

import io.swagger.models.auth.In;

/**
 * @author
 * @create 2020-11-23-9:22
 */
public class BaseService {

    //默认创建人admin(系统管理员)
    public  static  final  String ADMIN = "admin";
    //浏览、分享、申请增加变量
    public  static  final  int INCNUM = 1;
    //默认客户经理访问量
    public  static  final  Integer  VISITNUM= 100;
    //首次分享数
    public  static  final  Integer FIRSTSHARENUM = 1;
    //默认分享点击数
    public  static  final  Integer CLICKNUM = 0;
    //默认分享申请数
    public  static  final  Integer APPLYNUM = 0;
    //默认产品浏览数
    public  static  final Integer  VIEWNUM = 100;
    //默认产品分享数
    public  static  final  Integer SHARENUM = 10;



}
