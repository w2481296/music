<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>XX乐器店管理系统</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/login.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<!-- <header id="top">
    <div class="top">
        <img src="../images/header/logo.png" alt="" style="width:70px;height: 70px;"/>
        <span>XX乐器店管理系统</span>
    </div>
</header> -->
<div id="container">
    <div id="cover" class="rt">
        <form id="login-form" method="post" name="form1">
            <div class="txt">
                <p>
					乐器店管理系统登录
                </p>
                <div class="text">
                    <input type="text" placeholder="请输入您的用户名" name="lname" id="username" required>
                    <span><img src="../images/login/yhm.png"></span>
                </div>
                
                <div class="text">
                    <input type="password" id="password" placeholder="请输入您的密码" name="lwd" required minlength="6" maxlength="15">
                    <span><img src="../images/login/mm.png"></span>
                </div>
                <div class="chose">
                    <input type="checkbox" class="checkbox" id="ck_rmbUser">自动登录
                   	<span><a href="../user/showRegister.do" style="color: #ffffff;">新用户注册</a></span>
                    <span>忘记密码？</span>
                </div>
                <input class="button_login" type="button" value="登录" id="bt-login"/>
            </div>
        </form>
    </div>
</div>
<!--错误提示-->
<div id="showResult"></div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../jquery/jquery.cookie.js"></script>
<script>
    $("#username").blur(function(){
        var data = $("#username").val();
        if (data == null || data == "") {
            $("#showResult").text("用户名不能为空！");
            $("#showResult").css("color","red");
            return false;
        }
        
    });
</script>
<script>
    $('#bt-login').click(function(){
    	
        $.ajax({
        	url:"../user/login.do",
        	data:"username="+$("#username").val()+
        	      "&password="+$("#password").val(),
        	type:"post",
        	dataType:"json",
        	success:function(obj){
        		//显示错误信息
        		if(obj.state==0){
        			//设置错误信息
        			$("#showResult").html(obj.message);
        			//给错误信息的 文本设置为red
        			$("#showResult").css("color","red");
        		}else{
        			//清空错误信息
        			$("#showResult").html("");
        			Save();
        			//显示首页
        			location.href='../main/showIndex.do';
        		}
        	}
        });
        
		
    });
</script>
<script type="text/javascript">

    $(document).ready(function () {
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
            $.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
            $.cookie("username", str_username, { expires: 7 });
            $.cookie("password", str_password, { expires: 7 });
        }
        else {
            $.cookie("rmbUser", "false", { expire: -1 });
            $.cookie("username", "", { expires: -1 });
            $.cookie("password", "", { expires: -1 });
        }
    };
</script>
</body>
</html>