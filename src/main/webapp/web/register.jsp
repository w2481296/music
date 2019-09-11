<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>XX管理系统注册页面</title>
  <link href="../css/header.css" rel="stylesheet"/>
  <link href="../css/animate.css" rel="stylesheet"/>
  <link href="../css/login.css" rel="stylesheet" />
</head>
<body style="width: 100%;
    box-sizing: border-box;
    margin: 0px auto;
    overflow-x: hidden;
    height: 560px;
    background-image: url(../images/regist.jpeg);
    background-repeat: no-repeat;
    background-size: cover;
    -webkit-background-size: cover;
    background-position: center 0;"> 
<!-- 页面顶部-->
<!-- <header id="top">
  <div class="top">
    <img src="../images/header/logo.png" alt="" style="width:70px;height: 70px;"/>
    <span>欢迎注册</span>
  </div>
</header> -->
<div class="parent">
  <div class="container1">
    <div class="panel rt">
      <form id="form-register" method="post" action="">
        <div class="txt">
          <p style="font-size: 23px;">新用户注册
            <span>
              <a href="../user/showLogin.do">直接登录</a>
            </span>
          </p>
        </div>
        <div class="form-group">
          <label for="uname">用户名：</label>
          <input autocomplete required minlength="6" maxlength="9" type="text" placeholder="请输入用户名" autofocus name="uname" id="uname"/>
          <span class="msg-default" id="unamespan">用户名长度在6到9位之间</span>
        </div>
        <div class="form-group">
          <label for="upwd">登录密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="upwd" autofocus id="upwd"/>
          <span class="msg-default hidden">密码长度在6到12位之间</span>
        </div>
		 <div class="form-group">
          <label for="upwdconfirm">确认密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请确认密码" name="upwdconfirm" autofocus id="upwdconfirm"/>
          <span class="msg-default hidden">密码长度在6到12位之间</span>
        </div>
        <div class="form-group">
          <label for="phone">手机号：</label>
          <input id="phone" name="phone" placeholder="请输入您的手机号" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required type="text" />
          <span class="msg-default hidden" id="phonespan">请输入合法的手机号</span>
        </div>
        <div class="form-group">
          <label></label>
          <input type="button" value="提交注册信息" id="bt-register" style="width:278px"/>
        </div>
      </form>
    </div>
  </div>
</div>

<!--弹出的小广告-->
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
  $('#bt-register').click(function(){
    var lengths=0;
    $('.form-group').each(function(){
      if($(this).find('span').hasClass('msg-success')){
        lengths++;
      }
    });
    if(lengths==4){
    	$.ajax({
    		url:"../user/register.do",
    		//serialize()表示提交表单所有组件
    		data:$("#form-register").serialize(),
    		type:"post",
    		dataType:"json",
    		success:function(obj){
    			if(obj.state==0){
    				$("#unamespan").html(obj.message);
    				$("#unamespan").attr("class","msg-error");
    			}else{
    				console.log("跳转到登陆页面")
    				location="../user/showLogin.do";
    				//跳转到login页面
    			}
    		}
    	});
    }
    
  })
</script>
<script>
  /*1.对用户名进行验证*/
  uname.onblur = function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '用户名不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('用户名不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '用户名不能少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('用户名不能少于6位');
    }else {
      this.nextElementSibling.innerHTML = '用户名格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
      var data =document.getElementById("uname").value;
      if(!data){   //用户没有输入任何内容
        return;
      }
      /**发起异步GET请求，询问服务器用户名是否已经存在**/
	  $.ajax({
		  //定义请求的url
		  url:"../user/checkUsername.do",
		  //提交的数据
		  data:"username="+$("#uname").val(),
		  //发送请求的方式
		  type:"get",
		  //响应是数据格式
		  dataType:"json",
		  //处理成功响应的数据
		  success:function(obj){
			  //在span节点中设置显示信息
			  $("#unamespan").html(obj.message);
			  //如果state为0，设置样式为msg-error
			  if(obj.state==0){
				  $("#unamespan").attr("class","msg-error");
			  }else{
			  //如果state为1，设置样式为msg-success 
				  $("#unamespan").attr("class","msg-success");
			  }
		  }
	  });
    }
  }

  uname.onfocus = function(){
    this.nextElementSibling.innerHTML = '用户名长度在6到9位之间';
    this.nextElementSibling.className = 'msg-default';
  }
  upwd.onfocus = function(){
    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
    this.nextElementSibling.className = 'msg-default';
  }
  upwd.onblur = function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else {
      this.nextElementSibling.innerHTML = '密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  }
  

  upwdconfirm.onfocus = function(){
    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
    this.nextElementSibling.className = 'msg-default';
  }
  upwdconfirm.onblur = function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else {
      this.nextElementSibling.innerHTML = '密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  }

  /*3.对手机号进行验证*/
  phone.onblur = function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '手机号不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号不能为空');
    }else if(this.validity.patternMismatch){
      this.nextElementSibling.innerHTML = '手机号格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号格式不正确');
    }else {
      this.nextElementSibling.innerHTML = '手机号格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');

      var data =document.getElementById("phone").value;
      if(!data){   //用户没有输入任何内容
        return;
      }
      /**发起异步GET请求，询问服务器电话是否已经存在**/
     
      $.ajax({
    	  url:"../user/checkPhone.do",
    	  data:"phone="+$("#phone").val(),
    	  type:"get",
    	  dataType:"json",
    	  success:function(obj){
    		  $("#phonespan").html(obj.message);
    		  if(obj.state==0){
    			  $("#phonespan").attr("class","msg-error");
    		  }else{
    			  $("#phonespan").attr("class","msg-success");
    		  }
    	  }
      });
      
    }
  }
  phone.onfocus = function(){
    this.nextElementSibling.innerHTML = '请输入合法的手机号';
    this.nextElementSibling.className = 'msg-default';
  }
</script>
</body>
</html>