/**
 * 通用云平台,安全类，包括字符串加密等
 */
(function(exports){
    let Security = function(){
        /**
         * 动态加载一个md5的js,目的是为了封装一下，方便以后更换加密算法不用改html的引用，以及其他js
         */
        $.get(ucp.ajaxRequest.baseurlResAdmin+'js/md5.js');
    };
    /**
     * 将时间戳转换为普通日期格式
     * @param obj
     */
    Security.prototype.encrypt = function(param){
        return hex_md5(param);//暂时使用md5加密，以后可以替换你成其他加密算法
    }
    exports.Security = Security;
})(window);

(function(){
    window.ucp = window.ucp || {};
    window.ucp.security = window.ucp.security || new Security();
})();