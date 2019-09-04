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
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 入库管理 <span class="c-gray en">&gt;</span> 入库配件 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c"> 配件入库时间：
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d'})" id="datemin" class="input-text Wdate" style="width:120px;">
				-
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
				<input type="text" class="input-text" style="width:250px" placeholder="输入配件关键字" id="insname" name="">
				<button type="submit" class="btn btn-success radius" id="search" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
				<button type="submit" class="btn btn-success radius" id="clean" name="" style="width:70px">清空</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除配件</a> <a class="btn btn-primary radius" data-title="入库配件" _href="" onclick="member_show('入库配件','../main/showIndex17.do','','400','500')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 入库配件</a></span> <span class="r">共有数据：<span id="num2"></span> 条</span> </div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort" id="DataTables_Table_0">
					<thead>
						<tr class="text-c">
							<th style="width:10px"><input type="checkbox" name="" value=""></th>
							<th style="width:50px">ID</th>
							<th style="width:50px">名称</th>
							<th style="width:50px">类型</th>
							<th style="width:50px">规格</th>
							<th style="width:50px">成本</th>
							<th style="width:80px">定价</th>
							<th style="width:50px">入库数量</th>
							<th style="width:100px">工厂</th>
							<th style="width:150px">更新时间</th>
							<th style="width:150px">入库时间</th>
							<th style="width:50px">操作</th>
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

<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$("#table-data").html(''); 
	$.ajax({
		url :"../in/selectinstockByName1.do",
		type:"post",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
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
 				var inCost = result[i].inCost!=null?result[i].inCost:"";
 				var inPricing = result[i].inPricing!=null?result[i].inPricing:"";
 				var inQty = result[i].inQty!=null?result[i].inQty:"";
 				var inManufacturers = result[i].inManufacturers!=null?result[i].inManufacturers:"";
 				var inUpdatetime = result[i].inUpdatetime!=null?result[i].inUpdatetime:"";
 				var inCreatetime = result[i].inCreatetime!=null?result[i].inCreatetime:"";
 			 	htmlStr='<tr class="text-c odd" role="row">'+
 				'<td><input type="checkbox" value="'+id+'" name=""></td>'+
				'<td>'+id+'</td>'+
				'<td><div class="c-999 f-12"><u style="cursor:pointer" class="text-primary" onclick="member_show('+"'"+inName+"'"+','+"'../main/showIndex13.do',"+"'"+id+"'"+','+"'360',"+"'400'"+')">'+inName+'</u></div></td>'+
				'<td>'+inType+'</td>'+
				'<td>'+inSpecifications+'</td>'+
				'<td>'+inCost+'</td>'+
				'<td>'+inPricing+'</td>'+
				'<td>'+inQty+'</td>'+
				'<td>'+inManufacturers+'</td>'+
				'<td>'+inUpdatetime+'</td>'+
				'<td>'+inCreatetime+'</td>'+
				'<td class="td-manage"><a title='+"'编辑'"+' href="javascript:;" onclick="member_show('+"'编辑',"+"'../main/showIndex18.do',"+"'"+id+"'"+','+"'700',"+"'550'"+')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'+id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'+
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
		url :"../in/selectinstockByName1.do",
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
 				var inCost = result[i].inCost!=null?result[i].inCost:"";
 				var inPricing = result[i].inPricing!=null?result[i].inPricing:"";
 				var inQty = result[i].inQty!=null?result[i].inQty:"";
 				var inManufacturers = result[i].inManufacturers!=null?result[i].inManufacturers:"";
 				var inUpdatetime = result[i].inUpdatetime!=null?result[i].inUpdatetime:"";
 				var inCreatetime = result[i].inCreatetime!=null?result[i].inCreatetime:"";
 			 	htmlStr='<tr class="text-c odd" role="row">'+
 				'<td><input type="checkbox" value="'+id+'" name=""></td>'+
				'<td>'+id+'</td>'+
				'<td><div class="c-999 f-12"><u style="cursor:pointer" class="text-primary" onclick="member_show('+"'"+inName+"'"+','+"'../main/showIndex13.do',"+"'"+id+"'"+','+"'360',"+"'400'"+')">'+inName+'</u></div></td>'+
				'<td>'+inType+'</td>'+
				'<td>'+inSpecifications+'</td>'+
				'<td>'+inCost+'</td>'+
				'<td>'+inPricing+'</td>'+
				'<td>'+inQty+'</td>'+
				'<td>'+inManufacturers+'</td>'+
				'<td>'+inUpdatetime+'</td>'+
				'<td>'+inCreatetime+'</td>'+
				'<td class="td-manage"><a title='+"'编辑'"+' href="javascript:;" onclick="member_show('+"'编辑',"+"'../main/showIndex18.do',"+"'"+id+"'"+','+"'700',"+"'550'"+')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'+id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'+
			'</tr>';
 				$("#table-data").append(htmlStr); 
 			}

		}
	});
	
	
});

/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',{
		btn: ['确定', '取消']
	  },function(index){
			var params={
					insid:id
			};
			$.ajax({
				url :"../in/delMainInstockById.do",
				data : params,
				type:"post",
				async : false,
				success : function(result) {
					if(result=="success"){
						$(obj).parents("tr").remove();
					}else{
						alert("删除失败");
					}
				}
			});
			layer.closeAll('dialog'); 
	},function(){
		layer.closeAll('dialog'); 
	});
}
/*用户-批量删除*/
function datadel(){
	console.log("批量删除");
	var ptag_ids = new Array(); //定义一个数组存储id
	     // 循环获取选中的checkbox
	    $("#table-data input[type='checkbox']:checked").each(function() {
	        if (!isNaN($(this).val())) {
	            ptag_ids.push($(this).val()); // 把值push进入数组里面
	        }
	    });
	    if(ptag_ids.length ==0){
	        alert('请选择至少一条记录删除');
	        return false;
	    }
		console.log("选择得id"+ptag_ids);
	     //调用删除函数
	    deletePtag(ptag_ids);
	}

	 

	function deletePtag(ptag_ids){
	     if(confirm("您确定要删除次会员或者多条会员记录吗？删除后无法恢复,请谨慎操作！")){
	         $.ajax({
	             type : "post",
	             url : "../in/delMainInsstockById.do",
	             data : { "ids" : ptag_ids.toString() },  //数组.toString();转成字符串，号隔开的
	             success : function(data) {
	                 console.info(data);
	                 if(data=="success"){
	                     $("#btn-danger").prop("checked", false);//成功后把全选按钮设置成不选中，其他下面刷新了，要不要都可以的
	                     location.reload();
	                 }else{
	                     alert(data.msg);
	                 }
	             }
	         });
	     }
	}

	/*入库配件编辑*/
	function member_show(title,url,id,w,h){
		localStorage.setItem("parteditId",id);
		layer_show(title,url,w,h);
	}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>