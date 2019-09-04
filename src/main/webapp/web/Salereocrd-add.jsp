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

<meta name="keywords" content="H-ui.admin">
<meta name="description" content="H-ui.admin">
</head>
<body>
<article class="cl pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2" style="margin-left: 80px;">商品选择：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input   id="insParts"  name="insParts"  style="display:none;">
				<input type="text"  id="insPartsname"   style="width: 80%;margin-left: -72px;"  class="input-text">
				<img alt="查看更多" src="../images/waiting.png" onclick="member_show('商品选择','../main/showIndex23.do','','500','500')" style="margin-left: 268px;width: 20px;height: 23px;margin-top: -54px;"> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3" style="margin-left: 80px;"></span>类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="true" style="width: 80%;margin-left: -72px;" name="inPricing" id="inPricing">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3" style="margin-left: 80px;">规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="true" style="width: 80%;margin-left: -72px;" id="inSpecifications" name="inSpecifications">
			</div>
		</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3" style="margin-left: 80px;"></span>售价：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" readonly="true" style="width: 80%;margin-left: -72px;" name="inPricing" id="inPricing">
				</div>
			</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3" style="margin-left: 80px;">库存数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="true" style="width: 80%;margin-left: -72px;" id="inQty" name="inQty">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3" style="margin-left: 80px;"><span class="c-red">*</span>数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 80%;margin-left: -72px;" id="inQty" name="inQty">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3" style="margin-left: 80px;">工厂：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly="true" style="width: 80%;margin-left: -72px;" id="inManufacturers" name="inManufacturers">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;确认销售&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

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
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			inName:{
				required:true,
			},
			inSpecifications:{
				required:true,
			},
			inCost:{
				required:true,
			},			
			inQty:{
				required:true,
			},			
			inManufacturers:{
				required:true,
			},			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
				$.ajax({
					url :"../in/addinstock.do",
					type:"post",
					async:false,
					data:$("#form-member-add").serializeArray(),
					success : function(result) {
						alert("入库成功！");
						parent.location.reload();
						layer_close();
					},
				});
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
//从子页面传值
function CallMoney(id,partname){
    $("#insParts").val(id);
    $("#insPartsname").val(partname);
}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>