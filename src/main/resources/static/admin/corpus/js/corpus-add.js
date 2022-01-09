
/**
 * 初始化
 */
$(document).ready(function () {
    //初始化语料类型选择下拉框
    initCorpusCatgory();

    //初始化layui
    layui.use(['element','layer','form'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();


        //监听提交
        form.on('submit(*)', function(data){

            //1、校验语料内容
            let content=$("input[name='content']").val();
            if(content == ''){
                layer.msg("语料内容不能为空！",{icon:5,time:2000});return false;
            }
            let exitContent= isContentExit(content);
            if(exitContent){
                let exitContent =
                layer.msg("此语料已存在！"+exitContent.getcontent,{icon:5,time:2000});
                return false;
            }

            //2、校验语料类型
            let catgory=$("select[name='catgory']").val();
            if(catgory == '' || catgory<0){
                layer.msg("请选择语料类型！",{icon:5,time:2000});return false;
            }
            //3、校验贡献者
            let donateId=$("input[name='donateId']").val();
            if(donateId == ''){
                layer.msg("贡献者不能为空！",{icon:5,time:2000});return false;
            }

            var parms = data.field;
            let options = {
                url:'admin/corpus/add',
                data:parms,
                onSuccess:function (res) {
                    layer.msg(res.message,{icon:6});
                },
                onFailure:function (res) {
                    layer.msg(res.message,{icon:5});
                }
            };
            ucp.ajaxRequest.post(options);
            return false;

        });

    });
});

function initCorpusCatgory() {
    //先清空
    $("#corpus_category").html('');
    let optionDefault = '<option value="-1">请选择语料类型</option>';
    $("#corpus_category").append(optionDefault);

    let options = {
        url:'/admin/corpus/getcorpus_catgory',
        onSuccess:function (res) {
            let corpusCatgoryArr = res.data;
            for(let i=0;i<corpusCatgoryArr.length;i++){
                let optionHtml = '<option value="'+ corpusCatgoryArr[i].code +'">'+ corpusCatgoryArr[i].otherName +'</option>';
                $("#corpus_category").append(optionHtml);
            }
        },
        onFailure:function (res) {
            alert(res.message);
        }
    }
    ucp.ajaxRequest.get(options);
}

/**
 * 校验此语料是否存在
 * @param content
 * @returns {boolean}
 */
function isContentExit(content) {
    let isExit = false;
    let options = {
        url:'/admin/corpus/isContentExit?content='+content,
        isAsync:false, //采用同步请求
        onSuccess:function (res) {
            isExit = res.data;
        },
        onFailure:function (res) {
            alert(res.message);
        }
    }
    ucp.ajaxRequest.get(options);
    return isExit;
}