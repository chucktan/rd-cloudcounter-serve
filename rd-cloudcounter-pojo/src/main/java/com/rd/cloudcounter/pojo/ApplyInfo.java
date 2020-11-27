package com.rd.cloudcounter.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "apply_info")
public class ApplyInfo {
    /**
     * 申请ID
     */
    @Id
    @Column(name = "applyID")
    private String applyID;

    /**
     * 申请人ID
     */
    @Column(name = "applyUserID")
    private String applyUserID;

    /**
     * 申请产品ID
     */
    @Column(name = "applyProID")
    private String applyProID;

    /**
     * 申请人姓名
     */
    @Column(name = "applyName")
    private String applyName;

    /**
     * 申请人身份证
     */
    @Column(name = "CertID")
    private String CertID;

    /**
     * 申请人手机号
     */
    private String phone;

    /**
     * 申请人地址
     */
    private String address;

    /**
     * 申请人办理方式 1柜面办理
     */
    @Column(name = "aptType")
    private Integer aptType;

    /**
     * 申请人办理方式名称
     */
    @Column(name = "aptTypeName")
    private String aptTypeName;

    /**
     * 预约办理时间
     */
    @Column(name = "aptTime")
    private String aptTime;

    /**
     * 状态 0申请中。1已处理
     */
    private Integer state;

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
     * 获取申请ID
     *
     * @return applyID - 申请ID
     */
    public String getApplyid() {
        return applyID;
    }

    /**
     * 设置申请ID
     *
     * @param applyid 申请ID
     */
    public void setApplyid(String applyid) {
        this.applyID = applyid;
    }

    /**
     * 获取申请人ID
     *
     * @return applyUserID - 申请人ID
     */
    public String getApplyuserid() {
        return applyUserID;
    }

    /**
     * 设置申请人ID
     *
     * @param applyuserid 申请人ID
     */
    public void setApplyuserid(String applyuserid) {
        this.applyUserID = applyuserid;
    }

    /**
     * 获取申请产品ID
     *
     * @return applyProID - 申请产品ID
     */
    public String getApplyproid() {
        return applyProID;
    }

    /**
     * 设置申请产品ID
     *
     * @param applyproid 申请产品ID
     */
    public void setApplyproid(String applyproid) {
        this.applyProID = applyproid;
    }

    /**
     * 获取申请人姓名
     *
     * @return applyName - 申请人姓名
     */
    public String getApplyname() {
        return applyName;
    }

    /**
     * 设置申请人姓名
     *
     * @param applyname 申请人姓名
     */
    public void setApplyname(String applyname) {
        this.applyName = applyname;
    }

    /**
     * 获取申请人身份证
     *
     * @return CertID - 申请人身份证
     */
    public String getCertid() {
        return CertID;
    }

    /**
     * 设置申请人身份证
     *
     * @param certid 申请人身份证
     */
    public void setCertid(String certid) {
        this.CertID = certid;
    }

    /**
     * 获取申请人手机号
     *
     * @return phone - 申请人手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置申请人手机号
     *
     * @param phone 申请人手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取申请人地址
     *
     * @return address - 申请人地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置申请人地址
     *
     * @param address 申请人地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取申请人办理方式 1柜面办理
     *
     * @return aptType - 申请人办理方式 1柜面办理
     */
    public Integer getApttype() {
        return aptType;
    }

    /**
     * 设置申请人办理方式 1柜面办理
     *
     * @param apttype 申请人办理方式 1柜面办理
     */
    public void setApttype(Integer apttype) {
        this.aptType = apttype;
    }

    /**
     * 获取申请人办理方式名称
     *
     * @return aptTypeName - 申请人办理方式名称
     */
    public String getApttypename() {
        return aptTypeName;
    }

    /**
     * 设置申请人办理方式名称
     *
     * @param apttypename 申请人办理方式名称
     */
    public void setApttypename(String apttypename) {
        this.aptTypeName = apttypename;
    }

    /**
     * 获取预约办理时间
     *
     * @return aptTime - 预约办理时间
     */
    public String getApttime() {
        return aptTime;
    }

    /**
     * 设置预约办理时间
     *
     * @param apttime 预约办理时间
     */
    public void setApttime(String apttime) {
        this.aptTime = apttime;
    }

    /**
     * 获取状态 0申请中。1已处理
     *
     * @return state - 状态 0申请中。1已处理
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 0申请中。1已处理
     *
     * @param state 状态 0申请中。1已处理
     */
    public void setState(Integer state) {
        this.state = state;
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