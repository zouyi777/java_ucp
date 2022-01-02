package com.zyyu.ucp.utils;

import com.zyyu.ucp.security.WebConfig;
import org.springframework.boot.system.ApplicationHome;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

public class FileHandleUtil {

    /** 文件（包括图片）存放的根目录 **/
    public static final  String uploadDir = "upload";

    /** 图片存放的目录 **/
    public static final  String imageDir = "image";

    /** 其他文件存放的目录 **/
    public static final  String fileDir = "comfile";

    /**日志文件存放目录*/
    public static final  String logDir = "ucplog";

    /**
     * 上传单个文件
     * @return 成功：上传后的文件访问路径，失败返回：null
     */
    public static String upload(MultipartFile uploadFile) throws Exception {

        //在部署的jar的父目录下新建upload目录（也即使和jar包同级）
        String saveFilePath = File.separator+imageDir+File.separator;
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
//        return saveFile.getAbsolutePath();
        return filename;
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
        return getJARootPath()+File.separator + uploadDir;
    }

    /**
     * 获取日志文件的存放目录
     * @return
     */
    public static String getLogPath(){
        return getJARootPath()+File.separator + logDir;
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

    /**
     * 获取图片完整的url路径
     * @param baseUrl
     * @param path
     * @return
     */
    public static String getImageWholeUrl(String baseUrl,String path){
        String wholePath = baseUrl + WebConfig.STATIC_RES_ROOT_PATH+"/"+ imageDir+"/"+path;
        return wholePath;
    }
}
