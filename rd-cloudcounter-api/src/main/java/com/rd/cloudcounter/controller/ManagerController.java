package com.rd.cloudcounter.controller;

import com.rd.cloudcounter.pojo.ApplyInfo;
import com.rd.cloudcounter.pojo.CustomerManager;
import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.ManagerBo;
import com.rd.cloudcounter.resource.FileUpload;
import com.rd.cloudcounter.service.CustomerManagerService;
import com.rd.cloudcounter.utils.DateUtil;
import com.rd.cloudcounter.utils.RDJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

        if (StringUtils.isBlank(managerBo.getManagername())){
            return  RDJSONResult.errorMsg("客户经理名称不能为空");
        }

        if (StringUtils.isBlank(managerBo.getTitle())){
            return  RDJSONResult.errorMsg("客户经理职位不能为空");
        }

        if (StringUtils.isBlank(managerBo.getBelongorg())){
            return  RDJSONResult.errorMsg("客户经理所属机构不能为空");
        }

        managerService.CreateCusManager(managerBo);

        return  RDJSONResult.ok();
    }

    @ApiOperation(value = "获取客户经理信息",notes = "获取客户经理信息",httpMethod = "POST")
    @PostMapping("/query")
    public RDJSONResult query(
            @ApiParam(name = "managerId",value = "客户经理ID",required = true)
            @RequestParam String managerId){

        if (StringUtils.isBlank(managerId)){
            return  RDJSONResult.errorMsg("客户经理ID不能为空");
        }

        CustomerManager resManager =  managerService.queryCusManagerById(managerId);

        return  RDJSONResult.ok(resManager);
    }

    @ApiOperation(value = "更新客户经理头像",notes = "更新客户经理头像",httpMethod = "POST")
    @PostMapping("/uploadFace")
    public RDJSONResult uploadFace(
            @ApiParam(name = "managerId",value = "客户经理ID",required = true)
            @RequestParam String managerId,
            @ApiParam(name = "file",value = "客户经理头像",required = true)
            MultipartFile file, HttpServletRequest request, HttpServletResponse response){

        if (StringUtils.isBlank(managerId)){
            return  RDJSONResult.errorMsg("客户经理ID不能为空");
        }
        //定义头像保存地址
        String fileSpace = fileUpload.getImageManagerFaceLocation();

        //在路径上为每一个用户添加一个managerId，用于区分不同用户上传
        String uploadPathPrefix = File.separator + managerId;

        //开始上传文件
        if (file != null){
            //获取上传文件的名称
            String fileName = file.getOriginalFilename();
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
                    InputStream inputStream = file.getInputStream();
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
}
