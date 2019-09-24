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
    <dt><span>用户：</span><span class="f-18" id="vipNametitle"></span></dt>
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
				<input type="text" readonly class="input-text" style="width: 210px;"  id="username" name="username">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">权限：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="userrole" type="radio" value="1" id="userrole">
					<label for="role-1">超级管理员</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="userrole" value="2" name="userrole">
					<label for="role-2">管理员</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="userrole" value="3" name="userrole">
					<label for="role-3">售货员</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" name="email" id="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 210px;" id="phone" name="phone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"></span>上次更新时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" readonly class="input-text" style="width: 210px;" readonly="true" name="updatetime" id="updatetime">
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
		url :"../vip/queryuserById.do",
		type:"post",
		data:params,
		async : false,
		success : function(result) {
			localStorage.clear();
			document.getElementById("id").value=result[0].id!=null?result[0].id:"";
			document.getElementById("username").value=result[0].username!=null?result[0].username:"";
			var role=result[0].role!=null?result[0].role:"";
			if(role=="超级管理员"){
				$("input[name='userrole'][value=1]").attr("checked",true); 
			}else if(role=="管理员"){
				$("input[name='userrole'][value=2]").attr("checked",true); 
			}else if(role=="售货员"){
				$("input[name='userrole'][value=3]").attr("checked",true); 
			}
			document.getElementById("phone").value=result[0].phone!=null?result[0].phone:"";
			document.getElementById("email").value=result[0].email!=null?result[0].email:"";
			document.getElementById("updatetime").value=result[0].updatetime!=null?result[0].updatetime:"";
			document.getElementById("vipNametitle").innerText=result[0].username!=null?result[0].username:"";
		}
	});

});
function article_save_submit(){
	var role = $('input[name="userrole"]:checked').val(); 
	var id = $('#id').val(); 
	console.log("+"+role);
	var params={
			role:role,
			id:id
	};
	$.ajax({
		url :"../vip/updateuserinfo.do",
		type:"post",
		data:$("#form-member-add").serializeArray(),
		success : function(result) {
			$.ajax({
				url :"../vip/updateroleinfo.do",
				type:"post",
				data:params,
				success : function(result) {
					alert("修改成功！");
					parent.location.reload();
					layer_close();
				},
			});
		},
	});
	parent.location.reload();
}
</script>
</body>
</html>