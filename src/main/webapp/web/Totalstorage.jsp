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
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

<!--/meta 作为公共模版分离出去-->
<meta name="keywords" content="H-ui.admin v3.0">
<meta name="description" content="H-ui.admin v3.0">
</head>
<body>
<section class="Hui-article-box">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 综合统计 <span class="c-gray en">&gt;</span>入库汇总<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c"> 日期范围：
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d'})" id="datemin" class="input-text Wdate" style="width:120px;">
				-
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
				<input type="text" class="input-text" style="width:250px" placeholder="输入商品关键词" id="insname" name="">
				<button type="submit" class="btn btn-success radius" id="search" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
				<button type="submit" class="btn btn-success radius" id="clean" name="" style="width:70px">清空</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20"><span class="r">共有数据：<span id="num2"></span> 条</span> </div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort" id="DataTables_Table_0">
					<thead>
						<tr class="text-c">
							<th style="width:50px">ID</th>
							<th style="width:80px">名称</th>
							<th style="width:80px">规格</th>
							<th style="width:80px">类型</th>
							<th style="width:70px">定价(元)</th>
							<th style="width:70px">数量(件)</th>
							<th style="width:100px">厂商</th>
							<th style="width:150px">入库时间</th>
						</tr>
					</thead>
					<tbody id="table-data">
					</tbody>
				</table>
				<div id="mes" style="float:left;display:none">
					当前没有数据
				</div>
			</div>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script> 
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$("#table-data").html(''); 
	$.ajax({
		url :"../total/queryallinstock.do",
		type:"post",
		async : false,
		success : function(result) {
 			var allNum=result.length;
 			if(allNum==0){
 				document.getElementById("mes").style.display="block";
 				$('#num2').html(allNum);
 			}else{
 				$('#show').html(1);
 				$('#end').html(allNum);
 				$('#num').html(allNum);
 				$('#num2').html(allNum);
 			}
 			for(var i =0;i<allNum;i++){
 				var id= result[i].id;
 				var inName = result[i].inName;
 				var inType = result[i].inType!=null?result[i].inType:"";
 				var inSpecifications = result[i].inSpecifications!=null?result[i].inSpecifications:"";
 				var inPricing = result[i].inPricing!=null?result[i].inPricing:"";
 				var inQty = result[i].inQty!=null?result[i].inQty:"";
 				var inManufacturers = result[i].inManufacturers!=null?result[i].inManufacturers:"";
 				var inCreatetime = result[i].inCreatetime!=null?result[i].inCreatetime:"";
 			 	htmlStr='<tr class="text-c odd" role="row">'+
				'<td>'+id+'</td>'+
				'<td>'+inName+'</td>'+
				'<td>'+inType+'</td>'+
				'<td>'+inSpecifications+'</td>'+
				'<td>'+inPricing+'</td>'+
				'<td>'+inQty+'</td>'+
				'<td>'+inManufacturers+'</td>'+
				'<td>'+inCreatetime+'</td>'+
			'</tr>';
 				$("#table-data").append(htmlStr); 
 			}
		}
	});
	
}); 

/*-查询功能*/
$("#search").click(function(){
	$("#table-data").html(''); 
	document.getElementById("mes").style.display="none";
	var html = $('#datacount').children(); 
	$('#datacount').html(html); 
	var insname=$("#insname").val();
	var datemin=$("#datemin").val();
	var datemax=$("#datemax").val();
	console.log("=="+insname);
	var params={
			inName:insname,
			inTime1:datemin,
			inTime2:datemax
	};
	$.ajax({
		url :"../total/queryallinstock.do",
		data : params,
		type:"post",
		async : false,
		success : function(result) {
 			var allNum=result.length;
 			if(allNum==0){
 				document.getElementById("mes").style.display="block";
 				$('#num2').html(allNum);
 			}else{
 				$('#show').html(1);
 				$('#end').html(allNum);
 				$('#num').html(allNum);
 				$('#num2').html(allNum);
 			}
 			for(var i =0;i<allNum;i++){
 				var id= result[i].id;
 				var inName = result[i].inName;
 				var inType = result[i].inType!=null?result[i].inType:"";
 				var inSpecifications = result[i].inSpecifications!=null?result[i].inSpecifications:"";
 				var inPricing = result[i].inPricing!=null?result[i].inPricing:"";
 				var inQty = result[i].inQty!=null?result[i].inQty:"";
 				var inManufacturers = result[i].inManufacturers!=null?result[i].inManufacturers:"";
 				var inCreatetime = result[i].inCreatetime!=null?result[i].inCreatetime:"";
 			 	htmlStr='<tr class="text-c odd" role="row">'+
				'<td>'+id+'</td>'+
				'<td>'+inName+'</td>'+
				'<td>'+inType+'</td>'+
				'<td>'+inSpecifications+'</td>'+
				'<td>'+inPricing+'</td>'+
				'<td>'+inQty+'</td>'+
				'<td>'+inManufacturers+'</td>'+
				'<td>'+inCreatetime+'</td>'+
			'</tr>';
 				$("#table-data").append(htmlStr); 
 			}
		}
	});
	
	
});
/* 清空按钮 */
$("#clean").click(function(){
	$("#datemin").val("");
	$("#datemax").val("");
	$("#insname").val("");
});

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>