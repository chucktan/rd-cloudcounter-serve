package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.pojo.ShareInfo;
import com.rd.cloudcounter.pojo.bo.ShareBo;
import com.rd.cloudcounter.service.ShareService;
import com.rd.cloudcounter.utils.RDJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @create 2020-11-24-16:16
 */
@Api(value = "分享信息",tags = {"信息分享相关的接口"})
@RestController
@RequestMapping("share")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @ApiOperation(value = "用户分享",notes = "用户分享",httpMethod = "POST")
    @PostMapping("/create")
    public RDJSONResult create(
            @ApiParam(name = "shareBo",value = "分享信息Bo",required = true)
            @RequestBody ShareBo shareBo){

        //1.分享人及客户经理
        if (StringUtils.isBlank(shareBo.getShareUserId())||StringUtils.isBlank(shareBo.getShareManagerId())){
            return  RDJSONResult.errorMsg("分享信息：shareUserId|ShareManagerId不能为空");
        }
        //2.创建分享
        shareService.CreateShare(shareBo);

        return  RDJSONResult.ok();
    }


    @ApiOperation(value = "查询用户分享列表",notes = "查询用户分享列表",httpMethod = "POST")
    @PostMapping("/list")
    public RDJSONResult list(
            @ApiParam(name = "userId",value = "用户ID",required = true)
            @RequestBody String userId){


        if (StringUtils.isBlank(userId)){
            return  RDJSONResult.errorMsg("用户ID不能为空");
        }

        List<ShareInfo> resList = shareService.queryShareByUserId(userId);

        return  RDJSONResult.ok(resList);
    }
}
