var pageX = {
    curPage:1,
    isFirstLoad:true,
    isSearch:false
}
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
                    pageX.isFirstLoad = false;
                    if(pageX.isSearch){
                        searchUser(pagerInfo.curr);
                    }else{
                        initData(pagerInfo.curr);
                    }
                }
            });
        }

        var start = {
            min: '2020-01-01 0:0:0',
            max: '2099-12-31 23:59:59',
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: '2020-01-01 0:0:0',
            max: '2099-12-31 23:59:59',
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

        initData(pageX.curPage);//初始化
    });
    intEvent();
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
            if(pageX.isFirstLoad){
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
 * 搜索查询用户
 * @param curPage
 */
function searchUser(curPage){

    let createTimeStart = $('#LAY_demorange_s').val();
    let createTimeEnd = $('#LAY_demorange_e').val();
    if(createTimeStart && !createTimeEnd){
        layer.msg("请选择结束日期！",{icon:5,time:2000});return false;
    }
    if(createTimeEnd && !createTimeStart){
        layer.msg("请选择开始日期！",{icon:5,time:2000});return false;
    }

    let parms = {
        pageInfo:{
            currentPage:curPage
        },
        userName:$("input[name='userName']").val(),
        mobilePhone:$("input[name='mobilePhone']").val(),
        email:$("input[name='email']").val(),
        createTimeStart:createTimeStart,
        createTimeEnd:createTimeEnd
    };
    let options = {
        url:'admin/user/search_user',
        data:parms,
        onSuccess:function (res) {
            renderData(res.data);
            if(pageX.isFirstLoad){
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
    initListItemEvent();
}

/**
 * 初始化静态元素的事件
 * 注意：这种是事件绑定不要写在列表事件中，不然会被多次注册
 */
function intEvent() {
    //添加用户弹框
    $("#addUser").click(function () {
        x_admin_show('新增用户','user-add.html','600','500');
    });
    //点击搜索
    $("#searchUser").click(function (event) {

        pageX.curPage = 1;
        pageX.isFirstLoad  = true;
        pageX.isSearch = true;

        searchUser(pageX.curPage);
        //阻止表单提交，不然会刷新界面
        event.preventDefault();
    });
}
/**
 * 初始化列表事件
 */
function initListItemEvent(){
    //批量删除
    $("#multiDelete").click(function () {
        layer.confirm('确认要删除吗？', {icon: 3, title: '提示信息'}, function (index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
        });
    });
    //穿透详情
    $(".userItem").bind('click',function () {
        let param = {
            "userId":$(this).attr("data-id"),
            "isEdit":false
        }
        ucp.common.setUrlPram(param);
        x_admin_show('用户详情','user-detail.html','800','500');
    });
    //用户状态启用或停用
    $(".userStartOrStop").bind('click',function () {
        let $this = $(this);
        let userId = $this.attr("data-id");
        let statusEle = $this.parents("tr").find(".td-status span");
        if(statusEle.hasClass('layui-btn-disabled')){//如果已停用
            layer.confirm('确认要启用吗？', function (index) {
                $this.html('<i class="layui-icon">&#xe601;</i>');
                $this.attr('title','停用');
                statusEle.removeClass('layui-btn-disabled');
                statusEle.addClass('layui-btn-normal');
                layer.msg('已启用!', {icon: 6, time: 1000});
            });
        }else if(statusEle.hasClass('layui-btn-normal')){//如果已启用
            layer.confirm('确认要停用吗？', function (index) {
                $this.html('<i class="layui-icon">&#xe62f;</i>');
                $this.attr('title','启用');
                statusEle.removeClass('layui-btn-normal');
                statusEle.addClass('layui-btn-disabled');
                layer.msg('已停用!', {icon: 6, time: 1000});
            });
        }
        ucp.common.stopPropagationDefault();
    });
    //删除用户
    $(".userDlete").bind('click',function () {
        let userId = $(this).attr("data-id");
        layer.confirm('确认要删除吗？', {icon: 3, title: '提示信息'}, function (index) {
            let options = {
                url:'/admin/user/delete?userId='+userId,
                onSuccess:function (res) {
                    layer.msg('已删除!', {icon: 1, time: 1000});
                    initData(pageX.curPage);
                },
                onFailure:function (res) {
                    alert(res.message);
                }
            }
            ucp.ajaxRequest.get(options);
        });
        ucp.common.stopPropagationDefault();
    });
    //修改密码
    $(".userModifyPass").bind('click',function () {
        let userId = $(this).attr("data-id");
        x_admin_show('修改密码','user-password.html','600','500');
        ucp.common.stopPropagationDefault();
    });
    //编辑
    $(".userEdit").bind('click',function () {
        let param = {
            "userId":$(this).attr("data-id"),
            "isEdit":true
        }
        ucp.common.setUrlPram(param);
        x_admin_show('修改用户','user-detail.html','800','500');
        ucp.common.stopPropagationDefault();
    });

}

