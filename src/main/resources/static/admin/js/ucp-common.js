/**
 * 通用云平台,公共方法
 */

(function(exports){
    const URL_PARAM_KEY = 'url_param';

    let Common = function(){

    };
    /**
     * 设置url参数
     * @param obj
     */
    Common.prototype.setUrlPram = function(param){
        let jsonParam = JSON.stringify(param);
        localStorage.setItem(URL_PARAM_KEY, jsonParam);
    }
    /**
     * 获取url参数
     * @returns {string}
     */
    Common.prototype.getUrlPram = function(){
        let jsonParam = localStorage.getItem(URL_PARAM_KEY);
        return JSON.parse(jsonParam);
    }

    /**
     * 移除url参数
     */
    Common.prototype.deleteUrlPram = function(){
        localStorage.removeItem(URL_PARAM_KEY);
    }
    /**
     * 跳转到下一个页面
     * @param url
     * @param param
     */
    Common.prototype.next = function(url,param){
        window.location.href = url;
        this.setUrlPram(param);
    }

    /**
     *   获取url中传过来的参数
     * @param paramName 参数名
     * @returns {string|null}
     */
    Common.prototype.getUrlParam = function (paramName) {
            var reg = new RegExp('(^|&)' + paramName + '=([^&]*)(&|$)', 'i');
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                return unescape(r[2]);
            }
            return null;
    };

    /**
     * 获取Iframe的url中传过来的参数
     * @param paramName 参数名
     * @returns {string|null}
     */
    Common.prototype.getIframeUrlParam = function (paramName) {
            var reg = new RegExp("[^\?&]?" + encodeURI(paramName) + "=[^&]+");
            var arr = window.parent.document.getElementById("Ateon-SetParent-iframe").contentWindow.location.search.match(reg);
            if (arr != null) {
                return decodeURI(arr[0].substring(arr[0].search("=") + 1));
            }
            return null;
    };
    /**
     * 阻止事件的冒泡和元素的默认行为
     */
    Common.prototype.stopPropagationDefault = function () {
        let event=window.event || arguments.callee.caller.arguments[0];
        event.preventDefault();
        event.stopPropagation();
    };

    exports.Common = Common;
})(window);

(function(){
    window.ucp= window.ucp || {};
    window.ucp.common= window.ucp.common || new Common();
})();