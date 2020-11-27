package com.rd.cloudcounter.pojo.vo;

import javax.persistence.Column;

/**
 * 产品详情介绍Vo
 * @author
 * @create 2020-11-24-14:35
 */
public class ProDetailsVo {

    private String intrID;

    private String intrName;

    private String intrDetail;

    private String intrImgUrl;


    public String getIntrID() {
        return intrID;
    }

    public void setIntrID(String intrID) {
        this.intrID = intrID;
    }

    public String getIntrName() {
        return intrName;
    }

    public void setIntrName(String intrName) {
        this.intrName = intrName;
    }

    public String getIntrDetail() {
        return intrDetail;
    }

    public void setIntrDetail(String intrDetail) {
        this.intrDetail = intrDetail;
    }

    public String getIntrImgUrl() {
        return intrImgUrl;
    }

    public void setIntrImgUrl(String intrImgUrl) {
        this.intrImgUrl = intrImgUrl;
    }
}
