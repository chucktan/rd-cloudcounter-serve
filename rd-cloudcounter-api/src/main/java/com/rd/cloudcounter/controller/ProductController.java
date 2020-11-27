package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.enums.YesOrNo;
import com.rd.cloudcounter.pojo.ProductInfo;
import com.rd.cloudcounter.pojo.vo.ProInfoVo;
import com.rd.cloudcounter.pojo.vo.ProListVo;
import com.rd.cloudcounter.service.ProductService;
import com.rd.cloudcounter.utils.RDJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @create 2020-11-24-14:49
 */
@Api(value = "产品信息相关",tags = {"产品信息相关的接口"})
@RestController
@RequestMapping("product")
public class ProductController extends  baseController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "查询人气前三产品列表",notes = "查询人气前三产品列表",httpMethod = "POST")
    @PostMapping("/listTopThree")
    public RDJSONResult listTopThree(
            @ApiParam(name = "proType",value = "产品类型",required = true)
            @RequestParam int proType){

        if (StringUtils.isBlank(String.valueOf(proType))){
            return  RDJSONResult.errorMsg("产品类型不能为空");
        }

        List<ProInfoVo>  resList = productService.queryProListTopThree(proType);

        return  RDJSONResult.ok(resList);
    }


    @ApiOperation(value = "查询产品列表",notes = "查询产品列表",httpMethod = "POST")
    @PostMapping("/listPro")
    public RDJSONResult listPro(
            @ApiParam(name = "proType",value = "产品类型",required = true)
            @RequestParam int proType){

        if (StringUtils.isBlank(String.valueOf(proType))){
            return  RDJSONResult.errorMsg("产品类型不能为空");
        }
        List<ProductInfo>  resList = productService.queryProList(proType);

        return  RDJSONResult.ok(resList);
    }

    @ApiOperation(value = "获取产品详情",notes = "获取产品详情",httpMethod = "POST")
    @PostMapping("/proDetails")
    public RDJSONResult listProDetails(
            @ApiParam(name = "proId",value = "产品ID",required = true)
            @RequestParam String proId){

        if (StringUtils.isBlank(proId)){
            return  RDJSONResult.errorMsg("产品ID不能为空");
        }

        //1.获取产品详情信息
        ProListVo resProDetails = productService.queryProInfoById(proId);

        //2.该产品的浏览量+1
        boolean result = productService.updateProViewNum(proId,INCNUM);
        if (!result){
            return  RDJSONResult.errorMsg("更新产品浏览量失败");
        }
        return  RDJSONResult.ok(resProDetails);
    }

    @ApiOperation(value = "删除产品",notes = "删除产品",httpMethod = "POST")
    @PostMapping("/deletePro")
    public RDJSONResult deletePro(
            @ApiParam(name = "proId",value = "产品ID",required = true)
            @RequestParam String proId){

        if (StringUtils.isBlank(proId)){
            return  RDJSONResult.errorMsg("产品ID不能为空");
        }

        productService.updateProDetailsIsValid(proId, YesOrNo.NO.type);

        return  RDJSONResult.ok();
    }


}
