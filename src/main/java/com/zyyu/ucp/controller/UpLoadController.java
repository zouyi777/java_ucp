package com.zyyu.ucp.controller;

import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.utils.FileHandleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UpLoadController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(UpLoadController.class);

    @PostMapping("/upload")
    public Result uploads(HttpServletRequest request, MultipartFile[] files) {
        String resultPath=null;
        try {
            //遍历文件数组执行上传
            for (int i = 0; i < files.length; i++) {
                if (files[i] != null) {
                    //调用上传方法
                    resultPath = FileHandleUtil.upload(files[i]);
                }
            }
        } catch (Exception e) {
            logger.error("上传失败",e);
            return fail("上传失败");
        }
        return success(resultPath);
    }

    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir,MultipartFile file) throws Exception
    {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir +"/"+ filename);
        System.out.println("上传路径："+uploadDir +"/"+ filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
