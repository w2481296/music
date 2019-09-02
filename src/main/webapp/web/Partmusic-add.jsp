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
<link rel="Bookmark" href="../favicon.ico" >
<link rel="Shortcut Icon" href="../favicon.ico" />

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
			<label class="form-label col-xs-4 col-sm-2">配件id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="id" name="id">
			</div>
		</div>
		<div class="row cl" style="margin-top: 0px;">
			<label class="form-label col-xs-4 col-sm-2">配件名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="partsName" name="partsName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  readonly="readonly" id="partsType" name="partsType">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  id="partsSpecifications" name="partsSpecifications">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">库存数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  id="partsQty" name="partsQty">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">厂商：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="partsManufacturers"  name="partsManufacturers" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">配件展示价格：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:240px;">
				<input type="text" id="partsPricing"  name="partsPricing" class="input-text" style="width:90%">
				元</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">成本价格：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:240px;">
				<input type="text"  id="partsCost" name="partsCost" class="input-text" style="width:90%">
				元</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">配件备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea id="partsRemake" class="textarea"  placeholder="说点什么..." name="partsRemake" datatype="*10-100" ></textarea>
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
	if(localStorage.getItem("partseditId")==null){
		layer_close();
	}
	document.getElementById("form-article-add").reset(); 
	var editId=localStorage.getItem("partseditId");
	console.log("=="+editId);
	var params={
			ids:editId
	};
	$.ajax({
		url :"../parts/querypartById.do",
		type:"post",
		data:params,
		async : false,
		success : function(result) {
			localStorage.clear();
			document.getElementById("id").value=result[0].id!=null?result[0].id:"";
			document.getElementById("partsType").value=result[0].partsType!=null?result[0].partsType:"";
			document.getElementById("partsName").value=result[0].partsName!=null?result[0].partsName:"";
			document.getElementById("partsSpecifications").value=result[0].partsSpecifications!=null?result[0].partsSpecifications:"";
			document.getElementById("partsPricing").value=result[0].partsPricing!=null?result[0].partsPricing:"";
			document.getElementById("partsManufacturers").value=result[0].partsManufacturers!=null?result[0].partsManufacturers:"";
			document.getElementById("partsCost").value=result[0].partsCost!=null?result[0].partsCost:"";
			document.getElementById("partsQty").value=result[0].partsQty!=null?result[0].partsQty:"";
			$("#partsRemake").val(result[0].partsRemake!=null?result[0].partsRemake:"");
		}
	});

});
function article_save_submit(){
	$.ajax({
		url :"../parts/updatepartinfo.do",
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
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>