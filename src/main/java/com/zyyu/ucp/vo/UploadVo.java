package com.zyyu.ucp.vo;

/**
 * 文件上传后的返回对象
 */
public class UploadVo {

    //文件上传后的源路径
    private String srcPath;
    //文件上传后下载显示的url
    private String displayUrl;

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

}
