/**
 * 通用云平台,网络请求
 */
(function(exports){
    const BASEURL = 'http://127.0.0.1:8085/ucp/';
    const BASEURL_RES = BASEURL+'res/';
    const BASEURL_RES_IMAGE = BASEURL_RES+'image/';
    const BASEURL_RES_ADMIN = BASEURL_RES+'admin/';
    const ADMIN_LOGIN_URL = BASEURL_RES_ADMIN+'login-admin.html';
    const LOGIN_URL = BASEURL_RES+'login-admin.html';

    const TOKEN_KEY = 'auth_token';
    const REQUEST_GET = 'get';
    const REQUEST_POST = 'post';
    const DATATYPE = 'json';
    const CONTENTTYPE = 'application/json;charset=UTF-8';

    let AjaxRequest = function(){
        /**
         * 服务端接口基础url
         */
        this.baseUrl = BASEURL;
        this.baseurlRes = BASEURL_RES;
        this.baseurlResImage = BASEURL_RES_IMAGE;
        this.baseurlResAdmin = BASEURL_RES_ADMIN;
    }

    /**
     * 跳转到登录界面
     */
    function jumpToLogin(res,options){
        alert(res.message+",请重新登录");
        if(options.isCustomer){
            window.parent.location.href=LOGIN_URL;
        }else {
            window.parent.location.href=ADMIN_LOGIN_URL;
        }

    }

    /**
     * get请求封装
     * @param obj
     */
    AjaxRequest.prototype.get = function(options){
        if(!options) return;
        let isAsync = true;
        if(!options.isAsync){
            isAsync = false;
        }
        $.ajax({
            type:REQUEST_GET,
            url:this.baseUrl+options.url,
            async: isAsync,
            headers:{'auth_token': localStorage.getItem(TOKEN_KEY)},
            dataType:DATATYPE,
            contentType:CONTENTTYPE,
            success:function (res) {
                if(res.code==2000){
                    options.onSuccess(res);
                }else if(res.code == 3000 || res.code==3002 || res.code == 3003){
                    jumpToLogin(res,options);
                }else{
                    options.onFailure(res);
                }
            },
            error:function(res){
                options.onFailure(res);
            }
        });
    }

    /**
     * post请求封装
     * @param options
     */
    AjaxRequest.prototype.post = function (options) {
        if(!options) return;
        let isAsync = true;
        if(!options.isAsync){
            isAsync = false;
        }
        $.ajax({
            type:REQUEST_POST,
            url:this.baseUrl+options.url,
            async: isAsync,
            headers:{'auth_token': localStorage.getItem(TOKEN_KEY)},
            data:JSON.stringify(options.data),
            dataType:DATATYPE,
            contentType:CONTENTTYPE,
            success:function (res) {
                if(res.code==2000){
                    options.onSuccess(res);
                }else if(res.code == 3000 || res.code==3002 || res.code == 3003){
                    jumpToLogin(res,options);
                }else{
                    options.onFailure(res);
                }
            },
            error:function(res){
                options.onFailure(res);
            }
        });
    }

    /**
     *  上传文件专用
     * @param options
     */
    AjaxRequest.prototype.upload = function (options) {
        if(!options) return;
        $.ajax({
            type:REQUEST_POST,
            url:this.baseUrl+options.url,
            headers:{'auth_token': localStorage.getItem(TOKEN_KEY)},
            data:options.formData,
            processData: false,
            contentType: false,
            success:function (res) {
                if(res.code==2000){
                    options.onSuccess(res);
                }else if(res.code == 3000 || res.code==3002 || res.code == 3003){
                    jumpToLogin(res,options);
                }else{
                    options.onFailure(res);
                }
            },
            error:function(res){
                options.onFailure(res);
            }
        });
    }
    exports.AjaxRequest = AjaxRequest;
})(window);
(function(){
    window.ucp= window.ucp || {};
    window.ucp.ajaxRequest= window.ucp.ajaxRequest || new AjaxRequest();
})();