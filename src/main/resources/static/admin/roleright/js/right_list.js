var curPage=1;
var isFirstLoad=true;
/**
 * 初始化j
 */
$(document).ready(function(){
    layui.use(['laydate', 'element', 'laypage', 'layer'], function () {
        //以下模块根据需要引入
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

        //暴露显示页码信息的方法给外部使用
        window.showPage = function (totalPages) {
            laypage({
                cont: 'pageContainer',
                pages: totalPages,
                first: 1,
                last: totalPages,
                prev: '<em><</em>',
                next: '<em>></em>',
                //跳转页码时调用
                jump: function (pagerInfo,first){ //obj为当前页的属性和方法，第一次加载first为true
                    if(first) return;
                    isFirstLoad = false;
                    initData(pagerInfo.curr);
                }
            });
        }

        initData(curPage);//初始化
    });
});
/**
 * 从服务器获取初始数据
 */
function initData(curPage){
    let parms = {currentPage:curPage};
    let options = {
        url:'/admin/right/list',
        data:parms,
        onSuccess:function (res) {
            renderData(res.data);
            if(isFirstLoad){
                showPage(res.data.totalPage);
            }
        },
        onFailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.post(options);
}

/**
 * 模板渲染
 */
function renderData(result){
    $("#totalCount").text(result.totalCount);
    var pendingHtml=$("#table_tr_tpl").html();
    var tpledHtml=ucp.listView.tpl(pendingHtml,result.dataList);
    $("#tbody").html(tpledHtml);
}


