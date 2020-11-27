package com.rd.cloudcounter.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author
 * @create 2020-11-24-16:36
 */
@ApiModel(value = "申请Bo",description = "用户申请Bo")
public class ApplyBo {

    //BeanUtils.copy不能识别大小写，所以都改为小写
    @ApiModelProperty(value = "申请人ID", name = "applyuserid", example = "", required = true)
    private String applyuserid;

    @ApiModelProperty(value = "申请产品ID", name = "applyproid", example = "", required = true)
    private String applyproid;

    @NotBlank(message = "申请人姓名不能为空")
    @Length(max = 12, message = "申请人姓名不能超过12位")
    @ApiModelProperty(value = "申请人姓名", name = "applyname", example = "", required = true)
    private String applyname;

    @NotBlank(message = "申请人证件号不能为空")
    @ApiModelProperty(value = "申请人证件号", name = "certid", example = "", required = true)
    private String certid;

    @Pattern(regexp = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$", message = "手机格式不正确")
    @ApiModelProperty(value = "申请人电话", name = "phone", example = "", required = true)
    private String phone;

    @ApiModelProperty(value = "申请人地址", name = "address", example = "", required = true)
    private String address;

    @ApiModelProperty(value = "申请人办理类型", name = "apttype", example = "", required = true)
    private Integer apttype;

    @ApiModelProperty(value = "申请人预约时间", name = "apttime", example = "", required = true)
    private String apttime;

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(String applyuserid) {
        this.applyuserid = applyuserid;
    }

    public String getApplyproid() {
        return applyproid;
    }

    public void setApplyproid(String applyproid) {
        this.applyproid = applyproid;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public Integer getApttype() {
        return apttype;
    }

    public void setApttype(Integer apttype) {
        this.apttype = apttype;
    }

    public String getApttime() {
        return apttime;
    }

    public void setApttime(String apttime) {
        this.apttime = apttime;
    }
}
