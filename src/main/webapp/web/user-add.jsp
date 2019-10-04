<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" type="text/css"
	href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/style.css" />



<meta name="keywords" content="H-ui.admin v3.0">
<meta name="description" content="H-ui.admin v3.0">
</head>
<body>
	<article class="cl pd-20">
		<form action="/" method="post" class="form form-horizontal"
			id="form-change-password">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>用户名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="输入用户名" name="username" id="username">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off"
						placeholder="输入密码" name="password" id="password">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>确认密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off"
						placeholder="确认密码" name="password2">
				</div>
			</div>
			<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>权限：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<select name="ddlroom" class="selcet-input w48" id="roledata">
				</select>
			</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>手机号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="输入手机号" name="phone" id="phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>邮箱：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="输入邮箱" name="email" id="email">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<span style="color: red; margin-left: 40px;" id="tishi"></span>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="../lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="../lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
		$.ajax( {
		    url : '../vip/selectrole.do',
		    type : 'post',
		    success : function(result) {
		    	var navData = '<option>请选择权限</option>'; //定义变量存储
		        for(var i=0;i<result.length;i++){
					navData+='<option id="'+result[i].id+'" value="'+result[i].id+'">'+result[i].rolename+'</option>'
		        }
		        $('#roledata').html(navData);
		    }
		});

	});
		$(function() {
			$("#form-change-password").validate({
				rules : {
					username : {
						required : true,
						minlength : 3,
					},
					password : {
						required : true,
						minlength : 6,
						maxlength : 16,
					},
					password2 : {
						required : true,
						minlength : 6,
						maxlength : 16,
						equalTo : "#password",
					},
					userrole:{
						required:true,
					},
					phone : {
						required : true,
						number : true,
						isMobile : true,
					},
					email : {
						isEmail:true,
						required : true,
					},
				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					var change=false;
					var username = $('#username').val();
					var phone=$('#phone').val();
					var email=$('#email').val();
					$.ajax({
						url : '../user/checkUsername.do',
						data : {
							username : username,
							phone:phone,
							email:email,
						},
						type : 'post',
						success : function(obj) {
							if (obj== 0) {
								$('#tishi').html("用户名已存在");
							}else if(obj==1){
								$('#tishi').html("该手机已注册");
							}else if(obj==2){
								$('#tishi').html("该邮箱已注册");
							}else{
								regist();
							}
						}
					});
				}
			});
	});
		function regist(){
				$.ajax({
		    		url:"../user/register.do",
		    		data:$("#form-change-password").serialize(),
		    		type:"post",
		    		success:function(obj){
		    			if(obj.state==1){
		    				var role = $("#roledata").val();
		    				var username = $('#username').val();
		    				var params={
		    						role:role,
		    						username:username
		    				};
		    				$.ajax({
		    					url :"../vip/addrole.do",
		    					type:"post",
		    					data:params,
		    					success : function(result) {
		    						document.getElementById("form-change-password").reset();
					    			alert("添加成功");
					    			parent.location.reload();
									layer_close();
		    					},
		    				});
		    			}
		    		}
		    	});
		}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>