var curPage=1;
var isFirstLoad=true;
/**
 * 初始化
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

        var start = {
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('LAY_demorange_s').onclick = function () {
            start.elem = this;
            laydate(start);
        }
        document.getElementById('LAY_demorange_e').onclick = function () {
            end.elem = this
            laydate(end);
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
        url:'/admin/user/list',
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
    initEvent();
}

/**
 * 初始化事件
 */
function initEvent(){
    /**
     * 穿透到详情
     */
    $(".userItem").bind('click',function () {
        let userId = $(this).attr("data-id");
        let url = "./user-detail.html";
        let param = {
            "userId":userId,
            "isEdit":false
        }
        ucp.common.next(url,param);
    });
}


/**
 * 删除用户
 * @param id
 */
function deleteUser(userId){
    let options = {
        url:'/admin/user/delete?userId='+userId,
        onSuccess:function (res) {
            initData(curPage);
        },
        onFailure:function (res) {
            alert(res.message);
        }
    }
    ucp.ajaxRequest.get(options);
    ucp.common.stopPropagationDefault();
}


/**
 * 编辑
 */
function toEdit(userId) {
    let url = "././user_detail.html";
    let param = {
        "userId":userId,
        "isEdit":true
    }
    ucp.common.next(url,param);
    ucp.common.stopPropagationDefault();
}
