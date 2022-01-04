package com.zyyu.ucp.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileVo {

    //文件数组
    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

}
