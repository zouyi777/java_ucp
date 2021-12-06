$(document).ready(function(){

    layui.use(['laydate', 'element', 'laypage', 'layer'], function () {
        //以下模块根据需要引入
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

        init();//初始化
    });

});

function init(){
    let options = {
        url:'/admin/sys_info',
        onSuccess:function (res) {
            renderSystemInfoVo(res.data.systemInfoVo);
        },
        onFailure:function (res) {
            alert(res.message);
        }
    }
    ucp.ajaxRequest.get(options);
}

function renderSystemInfoVo(systemInfoVo) {
    if(systemInfoVo){
        $("#userName").text(systemInfoVo.userName);
        $("#computerName").text(systemInfoVo.computerName);
        $("#serverIP").text(systemInfoVo.serverIP);
        $("#domain").text(systemInfoVo.domain);
        $("#localPort").text(systemInfoVo.localPort);
        $("#javaVersion").text(systemInfoVo.javaVersion);
        $("#javaVendor").text(systemInfoVo.javaVendor);
        $("#javaHome").text(systemInfoVo.javaHome);
        $("#javaTotalMemory").text(systemInfoVo.javaTotalMemory);
        $("#javaFreeMemory").text(systemInfoVo.javaFreeMemory);
        $("#appServer").text(systemInfoVo.appServer);
        $("#dbType").text(systemInfoVo.dbType);
        $("#os").text(systemInfoVo.os);
        $("#osVsersion").text(systemInfoVo.osVsersion);
        $("#workDir").text(systemInfoVo.workDir);
        $("#fileUploadPath").text(systemInfoVo.fileUploadPath);
        $("#logDir").text(systemInfoVo.logDir);
    }
}