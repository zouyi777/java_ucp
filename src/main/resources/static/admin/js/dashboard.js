$(document).ready(function(){
    init();//初始化
    renderWeeklyStatistics();
    renderWorksStatistics();
    renderWorksYearsStatistics();
});

function init(){
    let options = {
        url:'/admin/dashboard',
        onSuccess:function (res) {
            renderTopCard(res.data.topCardVo);
            renderSystemInfoVo(res.data.systemInfoVo);
        },
        onFailure:function (res) {
            alert(res.message);
        }
    }
    ucp.ajaxRequest.get(options);
}

function renderTopCard(topCardVo) {
    if(topCardVo){
        $("#userCount").text(topCardVo.userCount);
        $("#dailyActiveCount").text(topCardVo.dailyActiveCount);
        $("#worksCount").text(topCardVo.worksCount);
        $("#noticeCount").text(topCardVo.noticeCount);
    }
}

function renderWeeklyStatistics() {
// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['资讯', '图片', '说说', '管理员登陆记录']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        color: ['#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
            '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
            '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'],
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            //boundaryGap: false,
            data: ["2018-02-26", "2018-02-27", "2018-02-28", "2018-03-01", "2018-03-02", "2018-03-03", "2018-03-04"]
        },
        yAxis: {
            type: 'value',
            //boundaryGap: false,
            //data:['1','2','3','4','5','6','7']
        },
        series: [
            {
                name: '资讯',
                type: 'line',
                stack: '总量',
                data: [5, 3, 6, 8, 3, 2, 4]
            },
            {
                name: '图片',
                type: 'line',
                stack: '总量',
                data: [2, 4, 6, 5, 6, 7, 8]
            },
            {
                name: '说说',
                type: 'line',
                stack: '总量',
                data: [3, 5, 8, 2, 4, 9, 10]
            },
            {
                name: '管理员登陆记录',
                type: 'line',
                stack: '总量',
                data: [5, 6, 8, 7, 9, 10, 1]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function renderWorksYearsStatistics() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('years'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '作品年度统计',
            subtext: '纯属虚构',
            x: 'center'
        },
        //color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
                type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            axisTick: {
                alignWithLabel: true
            }
        }],
        yAxis: [{
            type: 'value'
        }],
        series: [{
            name: '发布量',
            itemStyle: {
                normal: {
                    //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                    color: function (params) {
                        // build a color map as your need.
                        var colorList = [
                            '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                            '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                            '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    //以下为是否显示，显示位置和显示格式的设置了
                    label: {
                        show: true,
                        position: 'top',
                        formatter: '{c}\n{b}'
                    }
                }
            },
            type: 'bar',
            barWidth: '60%',
            data: [10, 8, 12, 14, 10, 6, 8, 7, 15, 9, 5, 6]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function renderWorksStatistics() {
    // 指定图表的配置项和数据
    var myChart = echarts.init(document.getElementById('area'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '作品类型数据统计',
            subtext: '文章总数',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        itemStyle: {
            normal: {
                color: function (params) {
                    var colorList = [
                        '#f36f8a', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                        '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                        '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                    ];
                    return colorList[params.dataIndex]
                },
                //以下为是否显示，显示位置和显示格式的设置了
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{b}\n{c}'
                }
            }
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['PHP', 'JavaScript', 'MySQL', 'jQuery', 'CSS', 'MUI',]
        },
        series: [{
            name: '文章总数',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: 19, name: 'PHP'},
                {value: 5, name: 'JavaScript'},
                {value: 6, name: 'MySQL'},
                {value: 10, name: 'jQuery'},
                {value: 8, name: 'CSS'},
                {value: 2, name: 'MUI'},
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function renderSystemInfoVo(systemInfoVo) {
    if(systemInfoVo){
        $("#userName").text(systemInfoVo.userName);
        $("#computerName").text(systemInfoVo.computerName);
        $("#serverIP").text(systemInfoVo.serverIP);
        $("#domain").text(systemInfoVo.domain);
        $("#localPort").text(systemInfoVo.localPort);
        $("#javaVersion").text(systemInfoVo.javaVersion);
        $("#javaVendor").text(systemInfoVo.javaVendor);
        $("#javaHome").text(systemInfoVo.javaHome);
        $("#javaTotalMemory").text(systemInfoVo.javaTotalMemory);
        $("#javaFreeMemory").text(systemInfoVo.javaFreeMemory);
        $("#appServer").text(systemInfoVo.appServer);
        $("#dbType").text(systemInfoVo.dbType);
        $("#os").text(systemInfoVo.os);
        $("#osVsersion").text(systemInfoVo.osVsersion);
        $("#workDir").text(systemInfoVo.workDir);
        $("#fileUploadPath").text(systemInfoVo.fileUploadPath);
    }
}