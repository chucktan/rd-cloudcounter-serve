package com.rd.cloudcounter.pojo.vo;

import java.util.List;

/**
 * 产品详情Vo
 * @author
 * @create 2020-11-24-11:12
 */
public class ProListVo {

    private String productID;

    private String proImgUrl;

    private Integer viewNum;

    private Integer shareNum;

    private Integer applyNum;

    //详情页面介绍列表
    List<ProDetailsVo> productDetailList;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProImgUrl() {
        return proImgUrl;
    }

    public void setProImgUrl(String proImgUrl) {
        this.proImgUrl = proImgUrl;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public List<ProDetailsVo> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<ProDetailsVo> productDetailList) {
        this.productDetailList = productDetailList;
    }
}
