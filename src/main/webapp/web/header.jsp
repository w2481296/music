<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>

<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="../images/header/logo4.png" style="width: 593px;height: 71px;margin-top: -20px;margin-left: 31px;" alt="logo"/>
    </div>
    <div class="rt" style="margin-top: 15px;">
        <ul class="lf">
        	<li>您好    ${user.username}</li>
           <!-- 如果user==null，说明没有登录 -->
           <c:if test="${user==null}">
            <li><a href="../user/showLogin.do">登录</a></li>
           </c:if>
           <!-- 如果user!=null，说明已经登录 -->
           <c:if test="${user!=null}">
            <li><a href="../user/exit.do"><img src="../images/header/exit.jpg" style="width: 36px;
    height: 100%;
    margin-top: -4px; alt="logo"/></a></li>
           </c:if>
       
        </ul>
    </div>
</header>