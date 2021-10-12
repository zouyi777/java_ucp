var curPage=1;
var totalPage=0;

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
                cont: 'pageContainer'
                , pages: totalPages
                , first: 1
                , last: 100
                , prev: '<em><</em>'
                , next: '<em>></em>'
            });
        }

        var start = {
            min: laydate.now()
            , max: '2099-06-16 23:59:59'
            , istoday: false
            , choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: laydate.now()
            , max: '2099-06-16 23:59:59'
            , istoday: false
            , choose: function (datas) {
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

    });
    initData(curPage);//初始化
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
            totalPage = res.data.totalPage;
            $("#total_page").text("共"+totalPage+"页");
            $("#cur_page").text(res.data.currentPage);
            $("#totalCount").text(res.data.totalCount);
            renderData(res.data.dataList);
            showPage(totalPage);
        },
        onfailure:function (res) {
            alert(res.message);
        }
    };
    ucp.ajaxRequest.post(options);
}

/**
 * 模板渲染
 */
function renderData(result){
    var pendingHtml=$("#table_tr_tpl").html();
    var tpledHtml=ucp.listView.tpl(pendingHtml,result);
    $("#tbody").html(tpledHtml);
    initEvent();
}

/**
 * 初始化事件
 */
function initEvent(){
    /**
     * 点击上一页
     */
    $("#up_page").click(function(){
        if(curPage>1){
            curPage--;
            initData(curPage);
        }else{
            alert("已经是第一页了");
        }
    });
    /**
     * 点击下一页
     */
    $("#next_page").click(function(){
        if(curPage<totalPage){
            curPage++;
            initData(curPage);
        }else{
            alert("已经是最后一页了");
        }
    });

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
        onfailure:function (res) {
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
