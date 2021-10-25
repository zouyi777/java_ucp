/**
 * 初始化
 */
$(document).ready(function(){
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form();
        var layer = layui.layer;

        //自定义验证规则
        // form.verify({
        //   nikename: function(value){
        //     if(value.length < 5){
        //       return '昵称至少得5个字符啊';
        //     }
        //   }
        //   ,pass: [/(.+){6,12}$/, '密码必须6到12位']
        //   ,repass: function(value){
        //       if($('#L_pass').val()!=$('#L_repass').val()){
        //           return '两次密码不一致';
        //       }
        //   }
        // });
        //监听提交
        form.on('submit(save)', function (data) {
            console.log(data);
            layer.alert("增加成功", {icon: 6}, function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });
    });

    initData();
    initEvent();
});
/**
 * 从服务器获取初始数据
 */
function initData(){
    let userId = ucp.common.getUrlPram().userId;
    let options = {
        url:'/admin/user/detail?userId='+userId,
        onSuccess:function (res) {
            renderData(res.data);
        },
        onFailure:function (res) {
            alert(res.message);
        }
    }
    ucp.ajaxRequest.get(options);
}

/**
 * 模板渲染
 */
function renderData(result){
    $( "input[name='userName']").val(result.userName);
    $( "input[name='password']").val(result.password);
    $( "input[name='nickName']").val(result.nickName);
    $( "input[name='idNumber']").val(result.idNumber);
    $( "input[name='realName']").val(result.realName);
    $( "input[name='mobilePhone']").val(result.mobilePhone);
}


function initEvent(){
    /**修改后提交*/
    $("#userEditBtn").click(function () {
        commitUserEdit();
    });
}
/***
 *  提交用户修改
 */
function commitUserEdit(){
    var parms = {
        userId:ucp.common.getUrlPram().userId,
        userName:$( "input[name='userName']").val(),
        password:$( "input[name='password']").val(),
        nickName:$( "input[name='nickName']").val(),
        idNumber:$( "input[name='idNumber']").val(),
        realName:$( "input[name='realName']").val(),
        mobilePhone:$( "input[name='mobilePhone']").val(),
    };
    let options = {
        url:'/admin/user/update',
        data:parms,
        onSuccess:function (res) {
            alert(res.message);
        },
        onFailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.post(options);
}