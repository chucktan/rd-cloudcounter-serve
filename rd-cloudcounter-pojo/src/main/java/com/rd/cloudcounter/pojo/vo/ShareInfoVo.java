package com.rd.cloudcounter.pojo.vo;

import java.util.Date;

/**
 * 分享信息Vo
 * @author
 * @create 2020-12-03-15:05
 */
public class ShareInfoVo {

    private String shareId;
    private Integer shareNum;
    private Integer clickNum;
    private Integer applyNum;
    private Date createdTime;

    private String managerName;
    private String managerPhotoImgUrl;

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhotoImgUrl() {
        return managerPhotoImgUrl;
    }

    public void setManagerPhotoImgUrl(String managerPhotoImgUrl) {
        this.managerPhotoImgUrl = managerPhotoImgUrl;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
