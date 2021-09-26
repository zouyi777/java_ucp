package com.zyyu.ucp.utils;

import org.springframework.boot.system.ApplicationHome;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

public class FileHandleUtil {

    /** 文件存放的目录 **/
    private static final  String uploaDir = "upload";

    /**
     * 上传单个文件
     * @return 成功：上传后的文件访问路径，失败返回：null
     */
    public static String upload(MultipartFile uploadFile) throws Exception {

        //在部署的jar的父目录下新建upload目录（也即使和jar包同级）
        String saveFilePath = File.separator+"image"+File.separator;
        File uploadDir = new File(getUploadPath(), saveFilePath);
        if(!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        //文件后缀名
        String suffix = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //存文件
        File saveFile = new File(uploadDir.getAbsolutePath(), filename);
        FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveFile);
        return saveFile.getAbsolutePath();
    }

    /**
     * 获取部署的jar的父目录
     * @return
     */
    public static String getJARootPath(){
        String jarParentPath = "";
        ApplicationHome applicationHome = new ApplicationHome(FileHandleUtil.class);
        if(applicationHome.getSource()!=null){
            jarParentPath = applicationHome.getSource().getParent();
        }
        return jarParentPath;
    }

    /**
     * 获取上传文件目录
     * @return
     */
    public static String getUploadPath(){
        return getJARootPath()+File.separator + uploaDir;
    }

    /**
     * 删除文件
     * @param path 文件访问的路径upload开始 如： /upload/image/test.jpg
     * @return true 删除成功； false 删除失败
     */
    public static boolean delete(String path) {
        File file = new File(getUploadPath(), path);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
