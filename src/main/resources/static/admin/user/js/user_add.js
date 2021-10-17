/**
 * 初始化
 */
$(document).ready(function(){
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form();
        var layer = layui.layer;

        //自定义验证规则
        form.verify({
            userName: function (value) {
                if (value.length < 2) {
                    return '用户名至少得2个字符啊';
                }
            },
            password: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function (data) {
            commitUserAdd(data.field,function (message) {
                layer.alert(message, {icon: 6}, function (currIndex) {
                    var parentIndex = parent.layer.getFrameIndex(window.name);// 获得frame索引
                    if(parentIndex){
                        parent.layer.close(parentIndex);//关闭当前frame
                    }else {
                        layer.close(currIndex);
                    }
                });
            });
            return false;//必须要写 return false;不然表单自动刷新
        });
    });
});

/***
 *  提交用户修改
 */
function commitUserAdd(parms,callback){
    let passEncrypt = ucp.security.encrypt(parms.password);
    parms.password = passEncrypt;
    let options = {
        url:'/admin/user/add',
        data:parms,
        onSuccess:function (res) {
            callback(res.message);
        },
        onFailure:function (res) {
            callback(res.message);
        }
    };
    ucp.ajaxRequest.post(options);
}