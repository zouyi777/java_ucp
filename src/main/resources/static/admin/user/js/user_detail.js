var userId;
var isEdit;

/**
 * 初始化
 */
$(document).ready(function(){
    //初始化一些列表跳转过来的参数
    userId = ucp.common.getUrlPram().userId;
    isEdit = ucp.common.getUrlPram().isEdit;
    //初始化layui模块
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
        // form.on('submit(save)', function (data) {
        //     console.log(data);
        //     layer.alert("增加成功", {icon: 6}, function () {
        //         // 获得frame索引
        //         var index = parent.layer.getFrameIndex(window.name);
        //         //关闭当前frame
        //         parent.layer.close(index);
        //     });
        //     return false;
        // });
    });

    initData();
    initEvent();
});
/**
 * 从服务器获取初始数据
 */
function initData(){
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
    if(isEdit){
        $('#detail-form input').removeAttr('readonly')
        $('#detail-form input').removeAttr('disabled');
        $('#detail-form textarea').removeAttr('readonly');
        $('#saveView').removeClass('display-none');
    }else{
        $('#detail-form input').attr('readonly','readonly');
        $('#detail-form input').attr('readonly','readonly');
        $('#detail-form input').attr('disabled','disabled');
        $('#detail-form textarea').attr('readonly','readonly');
        $('#saveView').addClass('display-none');
    }
    $('.userAvtar img').attr('src',ucp.ajaxRequest.baseurlResImage + result.avatar);
    $( "#userName").val(result.userName);
    if(result.state == 'NORMAL'){
        $( "#userStateUp").attr('checked','checked');
    }else{
        $( "#userStateDown").attr('checked','checked');
    }
    $( "input[name='nickName']").val(result.nickName);
    $( "input[name='idNumber']").val(result.idNumber);
    $( "input[name='realName']").val(result.realName);
    $( "input[name='birthday']").val(ucp.util.formatDate(result.birthday));
    if(result.gender.index == 10){
        $("#sexMan").attr('checked','checked');
    }else{
        $("#sexFemale").attr('checked','checked');
    }
    $( "input[name='mobilePhone']").val(result.mobilePhone);
    $( "input[name='email']").val(result.email);
    $( "input[name='address']").val(result.address);
    $( "textarea[name='slefWord']").val(result.slefWord);
}


function initEvent(){
    ///修改后提交
    $("#saveBtn").click(function () {
        commitUserEdit();
    });
}
/***
 *  提交用户修改
 */
function commitUserEdit(){
    var parms = {
        userId:userId,
        userName:$( "input[name='userName']").val(),
        state:1,
        nickName:$( "input[name='nickName']").val(),
        idNumber:$( "input[name='idNumber']").val(),
        realName:$( "input[name='realName']").val(),
        // birthday:$( "input[name='birthday']").val(),
        gender:10,
        mobilePhone:$( "input[name='mobilePhone']").val(),
        email:$( "input[name='email']").val(),
        address:$( "input[name='address']").val(),
        slefWord:$( "textarea[name='slefWord']").val(),
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