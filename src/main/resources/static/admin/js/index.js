var adminHomeObj={};

$(document).ready(function(){
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        //以上模块根据需要引入
    });
    //intTopTime();
    init();//主页初始化
    initEvent();//初始化事件
    testLog();
});

function intTopTime() {
    //顶部时间
    function getTime(){
        var myDate = new Date();
        var myYear = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
        var myMonth = myDate.getMonth()+1; //获取当前月份(0-11,0代表1月)
        var myToday = myDate.getDate(); //获取当前日(1-31)
        var myDay = myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
        var myHour = myDate.getHours(); //获取当前小时数(0-23)
        var myMinute = myDate.getMinutes(); //获取当前分钟数(0-59)
        var mySecond = myDate.getSeconds(); //获取当前秒数(0-59)
        var week = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];

        var nowTime = myYear+'-'+fillZero(myMonth)+'-'+fillZero(myToday)+'&nbsp;&nbsp;'+fillZero(myHour)+':'+fillZero(myMinute)+':'+fillZero(mySecond)+'&nbsp;&nbsp;';
        var nowWeek = week[myDay]+'&nbsp;&nbsp;'
        $('#time').html(nowTime);
        $('#week').html(nowWeek);
    };
    function fillZero(str){
        var realNum;
        if(str<10){
            realNum	= '0'+str;
        }else{
            realNum	= str;
        }
        return realNum;
    }
    setInterval(getTime,1000);
}

function init(){
    let options = {
        url:'/admin/home',
        onSuccess:function (res) {
            adminHomeObj = res.data;
            $("#logo").attr("src","./images/logo.svg")
            $("#admin-img").attr("src","./images/account.svg")
        },
        onFailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.get(options);
}

function initEvent() {

    $("#admin-info").click(function () {
        x_admin_show(adminHomeObj.adminNickName,'user/user-show.html','600','360','400');
    });

    //退出
    $("#login-out").click(function () {
        localStorage.removeItem("auth_token");
        window.location.href="./login-admin.html";
    });


}
//测试日志
function testLog(){
    let options = {
        url:'/log/test',
        onSuccess:function (res) {
            alert(res.data);
        },
        onFailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.get(options);
}