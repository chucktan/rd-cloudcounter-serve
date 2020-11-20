package com.rd.cloudcounter.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "product_detail")
public class ProductDetail {
    /**
     * 描述ID
     */
    @Id
    @Column(name = "intrID")
    private String intrID;

    /**
     * 产品ID
     */
    @Column(name = "productID")
    private Integer productID;

    /**
     * 描述名称
     */
    @Column(name = "intrName")
    private String intrName;

    /**
     * 描述详情
     */
    @Column(name = "intrDetail")
    private String intrDetail;

    /**
     * 描述图片 可以为空
     */
    @Column(name = "intrImgUrl")
    private String intrImgUrl;

    /**
     * 是否有效 0有效1无效
     */
    @Column(name = "isValid")
    private Integer isValid;

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
     * 获取描述ID
     *
     * @return intrID - 描述ID
     */
    public String getIntrid() {
        return intrID;
    }

    /**
     * 设置描述ID
     *
     * @param intrid 描述ID
     */
    public void setIntrid(String intrid) {
        this.intrID = intrid;
    }

    /**
     * 获取产品ID
     *
     * @return productID - 产品ID
     */
    public Integer getProductid() {
        return productID;
    }

    /**
     * 设置产品ID
     *
     * @param productid 产品ID
     */
    public void setProductid(Integer productid) {
        this.productID = productid;
    }

    /**
     * 获取描述名称
     *
     * @return intrName - 描述名称
     */
    public String getIntrname() {
        return intrName;
    }

    /**
     * 设置描述名称
     *
     * @param intrname 描述名称
     */
    public void setIntrname(String intrname) {
        this.intrName = intrname;
    }

    /**
     * 获取描述详情
     *
     * @return intrDetail - 描述详情
     */
    public String getIntrdetail() {
        return intrDetail;
    }

    /**
     * 设置描述详情
     *
     * @param intrdetail 描述详情
     */
    public void setIntrdetail(String intrdetail) {
        this.intrDetail = intrdetail;
    }

    /**
     * 获取描述图片 可以为空
     *
     * @return intrImgUrl - 描述图片 可以为空
     */
    public String getIntrimgurl() {
        return intrImgUrl;
    }

    /**
     * 设置描述图片 可以为空
     *
     * @param intrimgurl 描述图片 可以为空
     */
    public void setIntrimgurl(String intrimgurl) {
        this.intrImgUrl = intrimgurl;
    }

    /**
     * 获取是否有效 0有效1无效
     *
     * @return isValid - 是否有效 0有效1无效
     */
    public Integer getIsvalid() {
        return isValid;
    }

    /**
     * 设置是否有效 0有效1无效
     *
     * @param isvalid 是否有效 0有效1无效
     */
    public void setIsvalid(Integer isvalid) {
        this.isValid = isvalid;
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