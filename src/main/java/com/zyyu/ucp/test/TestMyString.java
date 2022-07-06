package com.zyyu.ucp.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestMyString {

    public static void main(String[] args) throws MalformedURLException {
        String str = "http://218.95.250.237:80/seeyon/rest/commonImage/showImage?size=original&id=4491442319515732640";
//        String fileId = str.substring(str.lastIndexOf("id=")+3);
        String fileId = str.split("id=")[1];
        String origin = str.substring(0,str.indexOf("seeyon"))+"seeyon";
        System.out.println(fileId);
        System.out.println(origin);

        String[] urlParts = str.split("\\?");
        //有参数
        String[] params = urlParts[1].split("&");
        Map map = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
        System.out.println(map.get("id"));
    }
}
