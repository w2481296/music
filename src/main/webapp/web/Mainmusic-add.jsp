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
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="row cl" style="margin-top: 0px;display:none">
			<label class="form-label col-xs-4 col-sm-2">乐器id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="id" name="id">
			</div>
		</div>
		<div class="row cl" style="margin-top: 0px;">
			<label class="form-label col-xs-4 col-sm-2">乐器名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="inName" name="inName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  readonly="readonly" id="inType" name="inType">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  id="inSpecifications" name="inSpecifications">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">库存数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  id="inQty" name="inQty">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">厂商：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="inManufacturers"  name="inManufacturers" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">配件：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input   id="inPart"  name="inPart"  style="display:none;">
				<input type="text"  id="inPartsname"   name=""  class="input-text">
				<img alt="查看更多" src="../images/waiting.png" onclick="member_show('挑选配件','../main/showIndex21.do','','500','500')" style="margin-left: 332px;width: 20px; height: 23px;margin-top: -27px;"> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">乐器展示价格：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:240px;">
				<input type="text" id="inPricing"  name="inPricing" class="input-text" style="width:90%">
				元</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">成本价格：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:240px;">
				<input type="text"  id="inCost" name="inCost" class="input-text" style="width:90%">
				元</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">乐器备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea id="inRemake" class="textarea"  placeholder="说点什么..." name="inRemake" datatype="*10-100" ></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>

<!--_footer 作为公共模版分离出去-->
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
	if(localStorage.getItem("editId")==null){
		layer_close();
	}
	document.getElementById("form-article-add").reset(); 
	var editId=localStorage.getItem("editId");
	var params={
			ids:editId
	};
	$.ajax({
		url :"../ins/queryinstruById.do",
		type:"post",
		data:params,
		async : false,
		success : function(result) {
			localStorage.clear();
			document.getElementById("id").value=result[0].id!=null?result[0].id:"";
			document.getElementById("inType").value="主乐器";
			document.getElementById("inName").value=result[0].insName!=null?result[0].insName:"";
			document.getElementById("inSpecifications").value=result[0].insSpecifications!=null?result[0].insSpecifications:"";
			document.getElementById("inPricing").value=result[0].insPricing!=null?result[0].insPricing:"";
			document.getElementById("inManufacturers").value=result[0].insManufacturers!=null?result[0].insManufacturers:"";
			document.getElementById("inPartsname").value=result[0].insParts!=null?result[0].insParts:"";
			document.getElementById("inCost").value=result[0].insCost!=null?result[0].insCost:"";
			document.getElementById("inQty").value=result[0].insQty!=null?result[0].insQty:"";
			$("#inRemake").val(result[0].insRemake!=null?result[0].insRemake:"");
		}
	});

});
function article_save_submit(){
	$.ajax({
		url :"../ins/updateinfo.do",
		type:"post",
		data:$("#form-article-add").serializeArray(),
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
    $("#inPartsname").val(partname);
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>