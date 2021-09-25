var curPage=1;
var totalPage=0;

/**
 * 初始化
 */
$(document).ready(function(){
    initData(curPage);//初始化
    initEvent();
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
            renderData(res.data.dataList);
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
 * 穿透到详情
 */
function toDetail(userId){
    let url = "././user_detail.html";
    let param = {
        "userId":userId,
        "isEdit":false
    }
    ucp.common.next(url,param);
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