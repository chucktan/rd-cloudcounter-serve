package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.enums.ApplyState;
import com.rd.cloudcounter.pojo.ApplyInfo;
import com.rd.cloudcounter.pojo.bo.ApplyBo;
import com.rd.cloudcounter.service.ApplyService;
import com.rd.cloudcounter.utils.MobileEmailUtils;
import com.rd.cloudcounter.utils.RDJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @create 2020-11-25-13:55
 */
@Api(value = "产品申请相关",tags = {"产品申请相关的接口"})
@RestController
@RequestMapping("apply")
public class ApplyController extends  baseController {

    @Autowired
    private ApplyService applyService;

    @ApiOperation(value = "申请信息列表查询",notes = "申请信息列表查询",httpMethod = "POST")
    @PostMapping("/list")
    public RDJSONResult list(
            @ApiParam(name = "userId",value = "申请人ID",required = true)
            @RequestParam String userId,
            @ApiParam(name = "state",value = "申请状态",required = true)
            @RequestParam int state){

        if (StringUtils.isBlank(userId)||StringUtils.isBlank(Integer.toString(state))){
            return  RDJSONResult.errorMsg("申请人ID|申请状态不能为空");
        }

        List<ApplyInfo> resList = applyService.queryApplyList(userId,state);

        return  RDJSONResult.ok(resList);
    }

    @ApiOperation(value = "获取申请信息",notes = "获取申请信息",httpMethod = "POST")
    @PostMapping("/query")
    public RDJSONResult query(
            @ApiParam(name = "applyId",value = "申请ID",required = true)
            @RequestParam String applyId){

        if (StringUtils.isBlank(applyId)){
            return  RDJSONResult.errorMsg("申请ID不能为空");
        }

        ApplyInfo resApply = applyService.queryApplyInfoById(applyId);

        return  RDJSONResult.ok(resApply);
    }


    @ApiOperation(value = "申请产品",notes = "申请产品",httpMethod = "POST")
    @PostMapping("/add")
    public RDJSONResult add(
            @ApiParam(name = "applyBo",value = "申请信息Bo",required = true)
            @RequestBody ApplyBo applyBo){

        RDJSONResult checkResult = checkApply(applyBo);
        if (checkResult.getStatus() != HTTP_OK_STATE){
            return  checkResult;

        }

        applyService.CreateApply(applyBo);

        return  RDJSONResult.ok();
    }

    @ApiOperation(value = "审核通过产品申请",notes = "审核通过产品申请",httpMethod = "POST")
    @PostMapping("/updateState")
    public RDJSONResult updateState(
            @ApiParam(name = "applyId",value = "申请信息ID",required = true)
            @RequestParam String applyId){

        if (StringUtils.isBlank(applyId)){
            return  RDJSONResult.errorMsg("申请信息ID不能为空");
        }

        applyService.updateApplyState(applyId, ApplyState.PROCESSED.type);

        return  RDJSONResult.ok();
    }



    private  RDJSONResult checkApply(ApplyBo applyBo){

        if (StringUtils.isBlank(applyBo.getApplyuserid())|StringUtils.isBlank(applyBo.getApplyproid()))
        {
            return  RDJSONResult.errorMsg("申请人ID|申请产品ID不能为空");
        }

        String applyName = applyBo.getApplyname();
        if (StringUtils.isBlank(applyName)){
            return  RDJSONResult.errorMsg("申请人姓名不能为空");
        }

        if (applyName.length() > NAME_SIZE){
            return  RDJSONResult.errorMsg("申请人姓名不能太长");
        }

        String certID  = applyBo.getCertid();
        if (StringUtils.isBlank(certID)){
            return  RDJSONResult.errorMsg("申请人身份证不能为空");
        }

        if (!MobileEmailUtils.checkCertIdIsOk(certID)) {
            return RDJSONResult.errorMsg("申请人身份证号不正确");
        }

        String phone = applyBo.getPhone();
        if (StringUtils.isBlank(phone)){
            return  RDJSONResult.errorMsg("申请人手机号不能为空");
        }

        if (phone.length() != MOBILE_SIZE){
            return RDJSONResult.errorMsg("申请人手机号不为11位");
        }

        if (!MobileEmailUtils.checkMobileIsOk(phone)){
            return RDJSONResult.errorMsg("申请人手机号不正确");
        }

        if (StringUtils.isBlank(applyBo.getAddress())){
            return  RDJSONResult.errorMsg("申请人地址不能为空");
        }

        if (StringUtils.isBlank(Integer.toString(applyBo.getApttype()))){
            return  RDJSONResult.errorMsg("申请办理方式不能为空");
        }

        if (StringUtils.isBlank(applyBo.getApttime())){
            return  RDJSONResult.errorMsg("申请办理时间不能空");
        }
        return  RDJSONResult.ok();
    }
}
