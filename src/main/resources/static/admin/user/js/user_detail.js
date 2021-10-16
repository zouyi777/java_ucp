/**
 * 初始化
 */
$(document).ready(function(){
    initView();
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


function initView() {
    let isEdit = ucp.common.getUrlPram().isEdit;
    if(isEdit){
        $("#user-detail-title").text("修改用户");
        $("#user-detail-submit").css("display","block");
    }else{
        $("#user-detail-title").text("用户详情");
        $("#user-detail-submit").css("display","none");
    }

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