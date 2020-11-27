package com.rd.cloudcounter.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author
 * @create 2020-11-24-15:37
 */
@ApiModel(value = "分享信息Bo",description = "用户分享数据信息Bo")
public class ShareBo {

    @ApiModelProperty(value = "用户ID",name = "shareUserId",example = "",required = true)
    private String shareUserId;

    @ApiModelProperty(value = "被分享客户经理ID",name = "shareManagerId",example = "",required = true)
    private String shareManagerId;

    @ApiModelProperty(value = "分享链接",name = "sharedUrl",example = "",required = true)
    private String sharedUrl;

    public String getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(String shareUserId) {
        this.shareUserId = shareUserId;
    }

    public String getShareManagerId() {
        return shareManagerId;
    }

    public void setShareManagerId(String shareManagerId) {
        this.shareManagerId = shareManagerId;
    }

    public String getSharedUrl() {
        return sharedUrl;
    }

    public void setSharedUrl(String sharedUrl) {
        this.sharedUrl = sharedUrl;
    }

}
