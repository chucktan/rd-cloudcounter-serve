package com.rd.cloudcounter.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "customer_manager")
public class CustomerManager {
    /**
     * 客户经理ID
     */
    @Id
    @Column(name = "managerID")
    private Integer managerID;

    /**
     * 行内员工ID
     */
    @Column(name = "bankUserID")
    private String bankUserID;

    /**
     * 客户经理姓名
     */
    @Column(name = "managerName")
    private String managerName;

    /**
     * 行内职务
     */
    private String title;

    /**
     * 头像
     */
    @Column(name = "photoImgUrl")
    private String photoImgUrl;

    /**
     * 所属网点ID
     */
    @Column(name = "belongOrgID")
    private String belongOrgID;

    /**
     * 所属网点
     */
    @Column(name = "belongOrg")
    private String belongOrg;

    /**
     * 访问总量
     */
    @Column(name = "visitNum")
    private String visitNum;

    /**
     * 活跃时间
     */
    @Column(name = "activeTime")
    private Date activeTime;

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
     * 获取客户经理ID
     *
     * @return managerID - 客户经理ID
     */
    public Integer getManagerid() {
        return managerID;
    }

    /**
     * 设置客户经理ID
     *
     * @param managerid 客户经理ID
     */
    public void setManagerid(Integer managerid) {
        this.managerID = managerid;
    }

    /**
     * 获取行内员工ID
     *
     * @return bankUserID - 行内员工ID
     */
    public String getBankuserid() {
        return bankUserID;
    }

    /**
     * 设置行内员工ID
     *
     * @param bankuserid 行内员工ID
     */
    public void setBankuserid(String bankuserid) {
        this.bankUserID = bankuserid;
    }

    /**
     * 获取客户经理姓名
     *
     * @return managerName - 客户经理姓名
     */
    public String getManagername() {
        return managerName;
    }

    /**
     * 设置客户经理姓名
     *
     * @param managername 客户经理姓名
     */
    public void setManagername(String managername) {
        this.managerName = managername;
    }

    /**
     * 获取行内职务
     *
     * @return title - 行内职务
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置行内职务
     *
     * @param title 行内职务
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取头像
     *
     * @return photoImgUrl - 头像
     */
    public String getPhotoimgurl() {
        return photoImgUrl;
    }

    /**
     * 设置头像
     *
     * @param photoimgurl 头像
     */
    public void setPhotoimgurl(String photoimgurl) {
        this.photoImgUrl = photoimgurl;
    }

    /**
     * 获取所属网点ID
     *
     * @return belongOrgID - 所属网点ID
     */
    public String getBelongorgid() {
        return belongOrgID;
    }

    /**
     * 设置所属网点ID
     *
     * @param belongorgid 所属网点ID
     */
    public void setBelongorgid(String belongorgid) {
        this.belongOrgID = belongorgid;
    }

    /**
     * 获取所属网点
     *
     * @return belongOrg - 所属网点
     */
    public String getBelongorg() {
        return belongOrg;
    }

    /**
     * 设置所属网点
     *
     * @param belongorg 所属网点
     */
    public void setBelongorg(String belongorg) {
        this.belongOrg = belongorg;
    }

    /**
     * 获取访问总量
     *
     * @return visitNum - 访问总量
     */
    public String getVisitnum() {
        return visitNum;
    }

    /**
     * 设置访问总量
     *
     * @param visitnum 访问总量
     */
    public void setVisitnum(String visitnum) {
        this.visitNum = visitnum;
    }

    /**
     * 获取活跃时间
     *
     * @return activeTime - 活跃时间
     */
    public Date getActivetime() {
        return activeTime;
    }

    /**
     * 设置活跃时间
     *
     * @param activetime 活跃时间
     */
    public void setActivetime(Date activetime) {
        this.activeTime = activetime;
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