package com.rd.cloudcounter.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author
 * @create 2020-11-25-15:15
 */
@ApiModel(value = "客户经理Bo",description = "客户经理Bo")
public class ManagerBo {

    //BeanUtils.copy不能识别大小写，所以都改为小写
    @ApiModelProperty(value = "客户经理行内ID",name = "bankuserid",example = "500934",required = true)
    private String bankuserid;

    @ApiModelProperty(value = "客户经理姓名",name = "managername",example = "",required = true)
    private String managername;

//  private String photoImgUrl;

    @ApiModelProperty(value = "客户经理行内职务",name = "title",example = "客户经理",required = true)
    private String title;

    @ApiModelProperty(value = "客户经理电话",name = "phone",example = "189287347xx",required = true)
    private String phone;

    @ApiModelProperty(value = "所属网点ID",name = "belongorgid",example = "",required = true)
    private String belongorgid;

    @ApiModelProperty(value = "所属网点名称",name = "belongorg",example = "童店支行",required = true)
    private String belongorg;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBankuserid() {
        return bankuserid;
    }

    public void setBankuserid(String bankuserid) {
        this.bankuserid = bankuserid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getBelongorgid() {
        return belongorgid;
    }

    public void setBelongorgid(String belongorgid) {
        this.belongorgid = belongorgid;
    }

    public String getBelongorg() {
        return belongorg;
    }

    public void setBelongorg(String belongorg) {
        this.belongorg = belongorg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
