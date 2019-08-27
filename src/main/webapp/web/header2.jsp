<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>

<header id="top" class="fixed_nav">
    <div class="rt" style="margin-left: 0px;height: 47px;background-color: #f5f5f5;">
        <ul class="lf" style="padding-top: 12px;">
        	<li>当前位置:</li>
        </ul>
        <hr style="size:10px;color:red;margin-top: 10px;"/>
    </div>
</header>
<script>
	$(function(){
		if(localStorage.getItem("men")!=null){
			$('li').text("当前位置:"+localStorage.getItem("men"));
		}
		localStorage.clear();
	})
</script>