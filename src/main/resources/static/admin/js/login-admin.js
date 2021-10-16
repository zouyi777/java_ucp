/**
 * 初始化
 */
$(document).ready(function(){
    $("#login-admin").click(function () {
        login_admin();
    });

});

function login_admin(){
    var parms = {
        adminName:$( "input[name='username']").val(),
        adminPassword:$( "input[name='password']").val()
    };
    let options = {
        url:'admin/login',
        data:parms,
        onSuccess:function (res) {
            localStorage.setItem('auth_token', res.data);
            window.location.href="./index.html";
        },
        onFailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.post(options);
}
