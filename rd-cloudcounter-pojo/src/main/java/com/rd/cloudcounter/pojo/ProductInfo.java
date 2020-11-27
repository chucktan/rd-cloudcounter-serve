package com.rd.cloudcounter.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "product_info")
public class ProductInfo {
    /**
     * 产品ID
     */
    @Id
    @Column(name = "productID")
    private String productID;

    /**
     * 产品类别
     */
    @Column(name = "productType")
    private Integer productType;

    /**
     * 产品类别名称 1消费金融2公司金融3理财产品
     */
    @Column(name = "productTypeName")
    private String productTypeName;

    /**
     * 产品名称
     */
    @Column(name = "productName")
    private String productName;

    /**
     * 产品简介
     */
    private String introduce;

    /**
     * 产品简介显示图片
     */
    @Column(name = "intrImgUrl")
    private String intrImgUrl;

    /**
     * 产品主页大图
     */
    @Column(name = "proImgUrl")
    private String proImgUrl;

    /**
     * 是否有效 0无效1有效
     */
    @Column(name = "isValid")
    private Integer isValid;

    /**
     * 浏览数
     */
    @Column(name = "viewNum")
    private Integer viewNum;

    /**
     * 分享数
     */
    @Column(name = "shareNum")
    private Integer shareNum;

    /**
     * 申请数
     */
    @Column(name = "applyNum")
    private Integer applyNum;

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 获取产品ID
     *
     * @return productID - 产品ID
     */
    public String getProductid() {
        return productID;
    }

    /**
     * 设置产品ID
     *
     * @param productid 产品ID
     */
    public void setProductid(String productid) {
        this.productID = productid;
    }

    /**
     * 获取产品类别
     *
     * @return productType - 产品类别
     */
    public Integer getProducttype() {
        return productType;
    }

    /**
     * 设置产品类别
     *
     * @param producttype 产品类别
     */
    public void setProducttype(Integer producttype) {
        this.productType = producttype;
    }

    /**
     * 获取产品类别名称 1消费金融2公司金融3理财产品
     *
     * @return productTypeName - 产品类别名称 1消费金融2公司金融3理财产品
     */
    public String getProducttypename() {
        return productTypeName;
    }

    /**
     * 设置产品类别名称 1消费金融2公司金融3理财产品
     *
     * @param producttypename 产品类别名称 1消费金融2公司金融3理财产品
     */
    public void setProducttypename(String producttypename) {
        this.productTypeName = producttypename;
    }

    /**
     * 获取产品名称
     *
     * @return productName - 产品名称
     */
    public String getProductname() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productname 产品名称
     */
    public void setProductname(String productname) {
        this.productName = productname;
    }

    /**
     * 获取产品简介 主页图片
     *
     * @return introduce - 产品简介 主页图片
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置产品简介 主页图片
     *
     * @param introduce 产品简介 主页图片
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * 获取产品简介显示图片 详情页图片
     *
     * @return intrImgUrl - 产品简介显示图片 详情页图片
     */
    public String getIntrimgurl() {
        return intrImgUrl;
    }

    /**
     * 设置产品简介显示图片 详情页图片
     *
     * @param intrimgurl 产品简介显示图片 详情页图片
     */
    public void setIntrimgurl(String intrimgurl) {
        this.intrImgUrl = intrimgurl;
    }

    /**
     * 获取产品主页大图
     *
     * @return proImgUrl - 产品主页大图
     */
    public String getProimgurl() {
        return proImgUrl;
    }

    /**
     * 设置产品主页大图
     *
     * @param proimgurl 产品主页大图
     */
    public void setProimgurl(String proimgurl) {
        this.proImgUrl = proimgurl;
    }

    /**
     * 获取是否有效 0无效1有效
     *
     * @return isValid - 是否有效 0无效1有效
     */
    public Integer getIsvalid() {
        return isValid;
    }

    /**
     * 设置是否有效 0无效1有效
     *
     * @param isvalid 是否有效 0无效1有效
     */
    public void setIsvalid(Integer isvalid) {
        this.isValid = isvalid;
    }

    /**
     * 获取浏览数
     *
     * @return viewNum - 浏览数
     */
    public Integer getViewnum() {
        return viewNum;
    }

    /**
     * 设置浏览数
     *
     * @param viewnum 浏览数
     */
    public void setViewnum(Integer viewnum) {
        this.viewNum = viewnum;
    }

    /**
     * 获取分享数
     *
     * @return shareNum - 分享数
     */
    public Integer getSharenum() {
        return shareNum;
    }

    /**
     * 设置分享数
     *
     * @param sharenum 分享数
     */
    public void setSharenum(Integer sharenum) {
        this.shareNum = sharenum;
    }

    /**
     * 获取申请数
     *
     * @return applyNum - 申请数
     */
    public Integer getApplynum() {
        return applyNum;
    }

    /**
     * 设置申请数
     *
     * @param applynum 申请数
     */
    public void setApplynum(Integer applynum) {
        this.applyNum = applynum;
    }

    /**
     * 获取创建人
     *
     * @return CREATED_BY - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新人
     *
     * @return UPDATED_BY - 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置更新人
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_TIME - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}