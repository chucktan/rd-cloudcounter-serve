package com.rd.cloudcounter.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "share_info")
public class ShareInfo {
    /**
     * 分享ID
     */
    @Id
    @Column(name = "shareID")
    private String shareID;

    /**
     * 分享人ID
     */
    @Column(name = "shareUserID")
    private Integer shareUserID;

    /**
     * 被分享客户经理ID
     */
    @Column(name = "sharedMangerID")
    private Integer sharedMangerID;

    /**
     * 分享链接
     */
    @Column(name = "sharedUrl")
    private String sharedUrl;

    /**
     * 点击次数
     */
    @Column(name = "clickNum")
    private Integer clickNum;

    /**
     * 申请次数
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
     * 获取分享ID
     *
     * @return shareID - 分享ID
     */
    public String getShareid() {
        return shareID;
    }

    /**
     * 设置分享ID
     *
     * @param shareid 分享ID
     */
    public void setShareid(String shareid) {
        this.shareID = shareid;
    }

    /**
     * 获取分享人ID
     *
     * @return shareUserID - 分享人ID
     */
    public Integer getShareuserid() {
        return shareUserID;
    }

    /**
     * 设置分享人ID
     *
     * @param shareuserid 分享人ID
     */
    public void setShareuserid(Integer shareuserid) {
        this.shareUserID = shareuserid;
    }

    /**
     * 获取被分享客户经理ID
     *
     * @return sharedMangerID - 被分享客户经理ID
     */
    public Integer getSharedmangerid() {
        return sharedMangerID;
    }

    /**
     * 设置被分享客户经理ID
     *
     * @param sharedmangerid 被分享客户经理ID
     */
    public void setSharedmangerid(Integer sharedmangerid) {
        this.sharedMangerID = sharedmangerid;
    }

    /**
     * 获取分享链接
     *
     * @return sharedUrl - 分享链接
     */
    public String getSharedurl() {
        return sharedUrl;
    }

    /**
     * 设置分享链接
     *
     * @param sharedurl 分享链接
     */
    public void setSharedurl(String sharedurl) {
        this.sharedUrl = sharedurl;
    }

    /**
     * 获取点击次数
     *
     * @return clickNum - 点击次数
     */
    public Integer getClicknum() {
        return clickNum;
    }

    /**
     * 设置点击次数
     *
     * @param clicknum 点击次数
     */
    public void setClicknum(Integer clicknum) {
        this.clickNum = clicknum;
    }

    /**
     * 获取申请次数
     *
     * @return applyNum - 申请次数
     */
    public Integer getApplynum() {
        return applyNum;
    }

    /**
     * 设置申请次数
     *
     * @param applynum 申请次数
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