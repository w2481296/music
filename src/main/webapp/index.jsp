<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>XX乐器店管理系统</title>
<link href="css/header.css" rel="stylesheet" />
<link href="css/animate.css" rel="stylesheet" />
<link href="css/login.css" rel="stylesheet" />
<link href="css/verify.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="container">
		<div id="cover" class="rt">
			<form id="login-form" method="post" name="form1">
				<div class="txt">
					<p style="margin-left: 86px;">乐器店管理系统</p>
					<div class="text">
						<input type="text" placeholder="请输入您的用户名" name="lname"
							id="username" required> <span><img
							src="images/login/yhm.png"></span>
					</div>
					<div class="text">
						<input type="password" id="password" placeholder="请输入您的密码"
							name="lwd" required minlength="6" maxlength="15"> <span><img
							src="images/login/mm.png"></span>
					</div>
					<div class="con">
						<div id="mpanel"></div>
					</div>


					<div class="chose" style="margin-top: 10px;">
						<input type="checkbox" class="checkbox" id="ck_rmbUser">自动登录
						<span><a href="user/showRegister.do"
							style="color: #ffffff;">新用户注册</a></span>
						<!-- <span>忘记密码？</span> -->
					</div>
					<input class="button_login" type="button" value="登录" id="bt-login" />
				</div>
			</form>
		</div>
	</div>
	<!--错误提示-->
	<div id="showResult"></div>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="jquery/jquery.cookie.js"></script>
	<script src="js/verify.js"></script>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
	<script>
		$("#username").blur(function() {
			var data = $("#username").val();
			if (data == null || data == "") {
				$("#showResult").text("用户名不能为空！");
				$("#showResult").css("color", "red");
				return false;
			}

		});
	</script>
	<script>
		$('#mpanel').codeVerify(
				{
					type : 1,
					width : '150px',
					height : '30px',
					fontSize : '18px',
					codeLength : 4,
					btnId : 'bt-login', // 登陆按钮ID
					ready : function() {
					},
					success : function() {
						$.ajax({
							url : "user/login.do",
							data : "username=" + $("#username").val()
									+ "&password=" + $("#password").val()
									+ "&cip=" + returnCitySN["cip"] + "&cname="
									+ returnCitySN["cname"],
							type : "post",
							dataType : "json",
							success : function(obj) {
								//显示错误信息
								if (obj.state == 0) {
									//设置错误信息
									$("#showResult").html(obj.message);
									//给错误信息的 文本设置为red
									$("#showResult").css("color", "red");
								} else {
									//清空错误信息
									$("#showResult").html("");
									Save();
									//显示首页
									location.href = 'main/showIndex.do';
								}
							}
						});
						// 验证成功之后调用登陆方法
					},
					error : function() {
						$("#showResult").text("验证码错误！");
						$("#showResult").css("color", "red");
					}
				});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			if ($.cookie("rmbUser") == "true") {
				$("#ck_rmbUser").attr("checked", true);
				$("#username").val($.cookie("username"));
				$("#password").val($.cookie("password"));
			}
		});

		//记住用户名密码
		function Save() {
			//prop()表示判断复选框是否被选中。值是 true和false
			if ($("#ck_rmbUser").prop("checked")) {
				var str_username = $("#username").val();
				console.log(str_username);
				var str_password = $("#password").val();
				$.cookie("rmbUser", "true", {
					expires : 7
				}); //存储一个带7天期限的cookie
				$.cookie("username", str_username, {
					expires : 7
				});
				$.cookie("password", str_password, {
					expires : 7
				});
			} else {
				$.cookie("rmbUser", "false", {
					expire : -1
				});
				$.cookie("username", "", {
					expires : -1
				});
				$.cookie("password", "", {
					expires : -1
				});
			}
		};
	</script>
</body>
</html>