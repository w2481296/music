<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="../static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="../static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="../lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

</head>
<body>
<article class="cl pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl" style="display:none">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>ID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="id" name="id">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名字：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="inName" name="inName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="inSpecifications" name="inSpecifications">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>成本：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="inCost" name="inCost">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>定价：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" name="inPricing" id="inPricing">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="inQty" name="inQty">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">配件：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input   id="inPart"  name="inPart"  style="display:none;">
				<input type="text"  id="insPartsname"   style="width: 80%;margin-left: -72px;" name=""  class="input-text">
				<img alt="查看更多" src="../images/waiting.png" onclick="member_show('挑选配件','../main/showIndex21.do','','500','500')" style="    margin-left: -27px;
    width: 20px;
    height: 23px;
    margin-top: -4px;"> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>工厂：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="inManufacturers" name="inManufacturers">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 修改并提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script> 	
<script type="text/javascript">
$(function(){
	//清空表单
	if(localStorage.getItem("MainaddeditId")==null){
		layer_close();
	}
	//document.getElementById("form-article-add").reset(); 
	var vipeditId=localStorage.getItem("MainaddeditId");
	var params={
			ids:vipeditId
	};
	$.ajax({
		url :"../in/queryinstockById.do",
		type:"post",
		data:params,
		async : false,
		success : function(result) {
			localStorage.clear();
			document.getElementById("id").value=result[0].id!=null?result[0].id:"";
			document.getElementById("inName").value=result[0].inName!=null?result[0].inName:"";
			document.getElementById("inSpecifications").value=result[0].inSpecifications!=null?result[0].inSpecifications:"";
			document.getElementById("inCost").value=result[0].inCost!=null?result[0].inCost:"";
			document.getElementById("inPricing").value=result[0].inPricing!=null?result[0].inPricing:"";
			document.getElementById("inQty").value=result[0].inQty!=null?result[0].inQty:"";
			document.getElementById("insPartsname").value=result[0].inPart!=null?result[0].inPart:"";
			document.getElementById("inManufacturers").value=result[0].inManufacturers!=null?result[0].inManufacturers:"";
		}
	});

});
function article_save_submit(){
	$.ajax({
		url :"../in/updateinstock.do",
		type:"post",
		data:$("#form-member-add").serializeArray(),
		success : function(result) {
			alert("修改成功！");
			parent.location.reload();
			layer_close();
		},
	});
	parent.location.reload();
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
//从子页面传值
function CallMoney(id,partname){
    $("#inPart").val(id);
    $("#insPartsname").val(partname);
}
</script>
</body>
</html>