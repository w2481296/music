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

<title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
  <dl style="margin-left:80px; color:#fff">
    <dt><span>当前会员：</span><span class="f-18" id="vipNametitle"></span></dt>
  </dl>
</div>
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl" style="margin-top: 0px;display:none">
			<label class="form-label col-xs-4 col-sm-2">用户id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="id" name="id">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;"  id="vipName" name="vipName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="vipGender" type="radio" value="男" id="vipGender" checked>
					<label for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="vipGender" value="女" name="vipGender">
					<label for="sex-2">女</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>年龄：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" name="vipAge" id="vipAge">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" id="vipPhone" name="vipPhone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>积分：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" name="vipIntegral" id="vipIntegral">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>创建时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" readonly="true" name="vipCreatetime" id="vipCreatetime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>上次更新时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" readonly="true" name="vipUpdatetime" id="vipUpdatetime">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i>修改</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
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
	if(localStorage.getItem("vipeditId")==null){
		layer_close();
	}
	//document.getElementById("form-article-add").reset(); 
	var vipeditId=localStorage.getItem("vipeditId");
	console.log("=="+vipeditId);
	var params={
			ids:vipeditId
	};
	$.ajax({
		url :"../vip/queryvipById.do",
		type:"post",
		data:params,
		async : false,
		success : function(result) {
			localStorage.clear();
			document.getElementById("id").value=result[0].id!=null?result[0].id:"";
			document.getElementById("vipName").value=result[0].vipName!=null?result[0].vipName:"";
			document.getElementById("vipAge").value=result[0].vipAge!=null?result[0].vipAge:"";
			var vipGender=result[0].vipGender!=null?result[0].vipGender:"";
			if(vipGender=="男"){
				$("input[name='vipGender'][value=男]").attr("checked",true); 
			}else if(vipGender=="女"){
				$("input[name='vipGender'][value=女]").attr("checked",true); 
			}
			document.getElementById("vipPhone").value=result[0].vipPhone!=null?result[0].vipPhone:"";
			document.getElementById("vipIntegral").value=result[0].vipIntegral!=null?result[0].vipIntegral:"";
			document.getElementById("vipCreatetime").value=result[0].vipCreatetime!=null?result[0].vipCreatetime:"";
			document.getElementById("vipUpdatetime").value=result[0].vipUpdatetime!=null?result[0].vipUpdatetime:"";
			document.getElementById("vipNametitle").innerText=result[0].vipName!=null?result[0].vipName:"";
		}
	});

});
function article_save_submit(){
	$.ajax({
		url :"../vip/updatevipinfo.do",
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
</script>
</body>
</html>