/**
 * 初始化
 */
$(document).ready(function(){
    $("#login-admin").click(function () {
        login_admin();
    });

});

function login_admin(){
    let pass = $( "input[name='password']").val();
    let parms = {
        adminName:$( "input[name='username']").val(),
        adminPassword:ucp.security.encrypt(pass)
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
