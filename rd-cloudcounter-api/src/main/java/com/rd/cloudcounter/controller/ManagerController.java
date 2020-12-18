package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.pojo.CustomerManager;
import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.ManagerBo;
import com.rd.cloudcounter.resource.FileUpload;
import com.rd.cloudcounter.service.CustomerManagerService;
import com.rd.cloudcounter.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author
 * @create 2020-11-25-16:35
 */
@Api(value = "客户经理相关",tags = {"客户经理相关的接口"})
@RestController
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private CustomerManagerService managerService;

    @Autowired
    private FileUpload fileUpload;


    @ApiOperation(value = "创建客户经理",notes = "创建客户经理",httpMethod = "POST")
    @PostMapping("/create")
    public RDJSONResult create(
            @ApiParam(name = "managerBo",value = "客户经理Bo",required = true)
            @RequestBody ManagerBo managerBo){

        String bankUserId = managerBo.getBankuserid();
        if (StringUtils.isBlank(managerBo.getManagername())){
            return  RDJSONResult.errorMsg("客户经理名称不能为空");
        }

        if (StringUtils.isBlank(managerBo.getTitle())){
            return  RDJSONResult.errorMsg("客户经理职位不能为空");
        }

        if (StringUtils.isBlank(managerBo.getBelongorg())){
            return  RDJSONResult.errorMsg("客户经理所属机构不能为空");
        }

        if(!MobileEmailUtils.checkMobileIsOk(managerBo.getPhone())){
            return  RDJSONResult.errorMsg("客户经理手机号不正确");
        }

        if (StringUtils.isBlank(bankUserId)){
            return  RDJSONResult.errorMsg("客户经理行内ID不能为空");
        }

        CustomerManager customerManager = managerService.queryCusManagerByBankUserId(bankUserId);
        if (customerManager != null){
            return  RDJSONResult.errorMsg("行内ID对应的客户经理已存在，请删除后再新建");
        }

        managerService.CreateCusManager(managerBo);

        return  RDJSONResult.ok();
    }

    @ApiOperation(value = "获取客户经理信息",notes = "获取客户经理信息",httpMethod = "POST")
    @PostMapping("/query")
    public RDJSONResult query(
            @ApiParam(name = "managerId",value = "客户经理ID",required = true)
            @RequestParam String managerId,HttpServletRequest request,HttpServletResponse response){

        if (StringUtils.isBlank(managerId)){
            return  RDJSONResult.errorMsg("客户经理ID不能为空");
        }

        CustomerManager resManager =  managerService.queryCusManagerById(managerId);
        setNullProperty(resManager);
        //TODO 客户经理信息是否需要存缓存
        CookieUtils.setCookie(request,response,"manager", JsonUtils.objectToJson(resManager),true);
        return  RDJSONResult.ok(resManager);
    }

    @ApiOperation(value = "行内ID查询客户经理信息",notes = "行内ID查询客户经理信息",httpMethod = "POST")
    @PostMapping("/queryByBankUserId")
    public RDJSONResult queryByBankUserId(
            @ApiParam(name = "bankUserId",value = "客户经理行内ID",required = true)
            @RequestParam String bankUserId){

        if (StringUtils.isBlank(bankUserId)){
            return  RDJSONResult.errorMsg("客户经理行内ID不能为空");
        }

        CustomerManager resManager =  managerService.queryCusManagerByBankUserId(bankUserId);

        return  RDJSONResult.ok(resManager);
    }


    @ApiOperation(value = "删除客户经理",notes = "删除客户经理",httpMethod = "POST")
    @PostMapping("/delete")
    public RDJSONResult delete(
            @ApiParam(name = "bankUserId",value = "客户经理行内ID",required = true)
            @RequestParam String bankUserId){

        if (StringUtils.isBlank(bankUserId)){
            return  RDJSONResult.errorMsg("客户经理行内ID不能为空");
        }

        boolean reslut =  managerService.deleteCusManagerByBankUserId(bankUserId);

        if (!reslut){
            return RDJSONResult.errorMsg("删除客户经理失败");
        }
        return  RDJSONResult.ok();
    }

    @ApiOperation(value = "更新客户经理头像",notes = "更新客户经理头像",httpMethod = "POST")
    @PostMapping("/uploadFace")
    public RDJSONResult uploadFace(
            @ApiParam(name = "managerId",value = "客户经理ID",required = true)
            @RequestParam String managerId,
//            @ApiParam(name = "file",value = "客户经理头像",required = true)
//            MultipartFile file
            @ApiParam(name = "fileName",value = "客户经理头像地址（临时）",required = true)
            @RequestParam String fileName, HttpServletRequest request, HttpServletResponse response){

        if (StringUtils.isBlank(managerId)){
            return  RDJSONResult.errorMsg("客户经理ID不能为空");
        }

        if (StringUtils.isBlank(fileName)){
            return  RDJSONResult.errorMsg("头像地址不能为空");
        }

        File file = new File(fileName);

        //定义头像保存地址
        String fileSpace = fileUpload.getImageManagerFaceLocation();

        //在路径上为每一个用户添加一个managerId，用于区分不同用户上传
        String uploadPathPrefix = File.separator + managerId;

        //开始上传文件
        if (file != null){
            //获取上传文件的名称
//            String fileName = file.getOriginalFilename();
            FileOutputStream fileOutputStream = null;
            if (!StringUtils.isBlank(fileName)){
                //文件重命名 face.png-> ["face","png"]
                String fileNameArr[] = fileName.split("\\.");
                //获取文件后缀名
                String suffix = fileNameArr[fileNameArr.length-1];
                //图片格式限制，防止黑客攻击
                if (!suffix.equalsIgnoreCase("png")&&!suffix.equalsIgnoreCase("jpg")&&!suffix.equalsIgnoreCase("jpeg")){
                    return  RDJSONResult.errorMsg("上传文件格式不正确");
                }

                //文件名称重组 覆盖式上传,增量式：额外拼接当前时间
                String newFileName =  "face-"+managerId+"."+suffix;

                //上传头像最终保存位置
                String finalFacePath =fileSpace+uploadPathPrefix+File.separator+newFileName;

                //用于提供给web服务访问的地址
                uploadPathPrefix += ("/"+newFileName);

                File outFile = new File(finalFacePath);
                if (outFile.getParentFile() != null){
                    //创建文件夹
                    outFile.getParentFile().mkdirs();
                }
                //文件输出保存到目录
                try {
                    fileOutputStream = new FileOutputStream(outFile);
//                    InputStream inputStream = file.getInputStream();
                    InputStream inputStream = new FileInputStream(file);
                    IOUtils.copy(inputStream,fileOutputStream);

                }catch (IOException ex){
                    ex.printStackTrace();
                }finally {
                    try {
                        if (fileOutputStream !=null){
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            }

        }else {
            return RDJSONResult.errorMsg("上传文件不能为空");
        }

        //获取图片服务地址
        String imgServerUrl = fileUpload.getImageServerUrl();

        //由于浏览器可能存在缓存的情况，所以在这里需要加上时间蹉来保证更新后的图片可以及时更新
        String finalManagerFaceUrl = imgServerUrl+uploadPathPrefix+"?t="+ DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN);
        //更新用户头像到数据库
        managerService.updateManagerFace(managerId,finalManagerFaceUrl);

        //TODO后续须修改

        return  RDJSONResult.ok();
    }

    private CustomerManager setNullProperty(CustomerManager customerManager){

        customerManager.setCreatedBy(null);
        customerManager.setCreatedTime(null);
        customerManager.setUpdatedBy(null);
        customerManager.setUpdatedTime(null);

        return  customerManager;
    }
}
