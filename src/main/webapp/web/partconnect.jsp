<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="../favicon.ico" >
<link rel="Shortcut Icon" href="../favicon.ico" />
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

<style type="text/css">
	table th, table td { 
		text-align: center;
		vertical-align: middle!important;
	}
</style>

<meta name="keywords" content="H-ui.admin">
<meta name="description" content="H-ui.admin">
</head>
<body>
		<div name="Bquery" id="Bquery" style="float:left;">
	     <label style="margin-left: 77px; font-weight: bold;">配件查询</label>
			<input type="text" name="search" id="search" value=""/>
			<input type="button" name="query" id="query" value="查询"/>
	    </div>
	    <input  type="button" name="back" id="back" value="返回" />
	    <table id="sparepartBom" border="1">
	    	<tr>
	    		<th>配件id</th>
	    		<th>配件名称</th>
	    		<th>配件规格</th>
	    	</tr>
		</table>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(document).ready(function() {
	 selBomSparepart();
});
function selBomSparepart(){ 
	 $.ajax({
		url :"../parts/selectpartByName.do",
		type:"post",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		success : function(result) {
		var allNum=result.length;
		 	for(var i =0;i<allNum;i++){
		 		var id= result[i].id;
	 			var insName = result[i].insName;
	 			var insSpecifications = result[i].insSpecifications!=null?result[i].insSpecifications:"";
	 			htmlStr='<tr ondblclick ="setCustomerNumber(this)">'+
				'<td>'+id+'</td>'+
				'<td>'+insName+'</td>'+
				'<td>'+insSpecifications+'</td>'+'</tr>';
	 			$("#sparepartBom").append(htmlStr);
		 	}
		 }
	});
}
$("#query").click(function(){
	$('#sparepartBom tbody').empty();
	
	var insName2=document.getElementById('search').value;
	var params={
			insName:insName2
	}
	 $.ajax({
			url :"../parts/selectpartByName.do",
			type:"post",
			data:params,
			success : function(result) {
			var allNum=result.length;
			var htmlStr="<tr><th>配件id</th><th>配件名称</th><th>配件规格</th></tr>";
			$("#sparepartBom").append(htmlStr);
			 	for(var i =0;i<allNum;i++){
			 		var id= result[i].id;
		 			var insName = result[i].insName;
		 			var insSpecifications = result[i].insSpecifications!=null?result[i].insSpecifications:"";
		 			htmlStr='<tr ondblclick ="setCustomerNumber(this)">'+
					'<td>'+id+'</td>'+
					'<td>'+insName+'</td>'+
					'<td>'+insSpecifications+'</td>'+'</tr>';
		 			$("#sparepartBom").append(htmlStr);
			 	}
			 }
		});
})
 //返回逻辑
  $("#back").click(function(){
	  
	  layer_close();
  })
  /**
* 配件点击事件
*/
function setCustomerNumber(tr){
	var sparepartBom = $(tr);
	var i=1;
	var id;
	var partname;
	sparepartBom.find("td").each(function(){
		if(i==1){
			id=$(this).text();
		}else if(i==2){
			partname=$(this).text();
		}else{
			return false;
		}
		i++;
	});
	window.parent.CallMoney(id,partname);
	layer_close();
}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>