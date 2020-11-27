package com.rd.cloudcounter.pojo.vo;

import javax.persistence.Column;

/**
 * 产品主页Vo
 * @author
 * @create 2020-11-24-10:44
 */
public class ProInfoVo {

    private String productID;

    private Integer productType;

    private String productTypeName;

    private String productName;

    private String introduce;

    private String intrImgUrl;

    private  Integer hotSum;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIntrImgUrl() {
        return intrImgUrl;
    }

    public void setIntrImgUrl(String intrImgUrl) {
        this.intrImgUrl = intrImgUrl;
    }

    public Integer getHotSum() {
        return hotSum;
    }

    public void setHotSum(Integer hotSum) {
        this.hotSum = hotSum;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
