<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

<!--/meta 作为公共模版分离出去-->
<meta name="keywords" content="H-ui.admin v3.0">
<meta name="description" content="H-ui.admin v3.0">
</head>
<body>
<section class="Hui-article-box">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 综合统计 <span class="c-gray en">&gt;</span>账务情况<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<button type="button" class="btn btn-success radius" id="change" name="" style="width:80px">列表模式</button>
			<div id="container" style="min-width:700px;height:400px"></div>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript">
$(function () {
	var data;
	$.ajax({
		url :"../total/querystockview.do",
		type:"post",
		async:false,
		success : function(result) {
			data=result;
		},
	});
	/* console.log("后台数据"+data);
	var timeall=[];
	var dottedBase =+new Date();
	for (var i = 0; i < 12; i++) {
	    var date = new Date(dottedBase += 3600 * 24 * 1000);
	    timeall.push([
	        date.getFullYear(),
	        date.getMonth() + 1,
	        date.getDate()
	    ].join('-'));
	} */
     
	$('#container').highcharts({
		colors: ['#FFF263', '#6AF9C4','#24CBE5'],
        title: {
            text: '汇总记录图',
            x: -20 //center
        },
        xAxis: {
            categories: [data[11].time, data[10].time, data[9].time, data[8].time,data[7].time,data[6].time,data[5].time,data[4].time,data[3].time, data[2].time,data[1].time,data[0].time]
        },
        yAxis: {
            title: {
                text: '单位(件)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '件'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '入库',
            type:'line',
            data: [data[11].qty, data[10].qty, data[9].qty, data[8].qty,data[7].qty,data[6].qty,data[5].qty,data[4].qty,data[3].qty, data[2].qty,data[1].qty,data[0].qty]
        }, {
            name: '出库',
            type:'line',
            data: [data[23].qty, data[22].qty, data[21].qty, data[20].qty,data[19].qty,data[18].qty,data[17].qty,data[16].qty,data[15].qty, data[14].qty,data[13].qty,data[12].qty]
        }, {
            name: '仓库总数',
            type:'line',
            data: [41, 58, 80, 100, 119, 129, 139, 149, 159, 171, 191, 197]
        }]
    });
});
$("#change").click(function(){
	window.location.href='../main/showIndex9.do'
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>