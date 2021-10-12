/**
 * 初始化
 */
$(document).ready(function(){
    initEvent();
});

function initEvent(){
    /**修改后提交*/
    $("#userAddBtn").click(function () {
        commitUserAdd();
    });
}
/***
 *  提交用户修改
 */
function commitUserAdd(){
    let parms = {
        userName:$( "input[name='userName']").val(),
        password:$( "input[name='password']").val(),
        nickName:$( "input[name='nickName']").val(),
        idNumber:$( "input[name='idNumber']").val(),
        realName:$( "input[name='realName']").val(),
        mobilePhone:$( "input[name='mobilePhone']").val(),
    };
    let options = {
        url:'/admin/user/add',
        data:parms,
        onSuccess:function (res) {
            alert(res.message);
        },
        onfailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.post(options);
}