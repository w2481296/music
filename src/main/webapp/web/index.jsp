<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="cn">
    <meta charset="UTF-8">
    <title>乐器店铺管理系统</title>
    <link href="../css/header.css" rel="stylesheet"/>
    
    <link rel="stylesheet" type="text/css" href="../css/nav.css">
 
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/nav.js"></script>
</head>
<body>
<!-- 页面顶部-->
<%@ include file="header.jsp" %>
<!-- 导航栏 -->
<div class="nav">
	<div class="nav-top">
		<div id="mi" style="border-bottom:1px solid rgba(255,255,255,.1)"><img src="../images/header/zong.png"  style="margin-left: 72px;width: 37px;height: 41px;margin-top: 2px;"></div>
	</div>
	<ul id="aat">
		
	</ul>
</div>
 

<script>
	$(function(){
		var navList = [
		  {
		    "p" : "乐器管理",
		    "c" : ["主乐器管理","配件管理"]
		  },
		  {
		    "p" : "入库管理",
		    "c" : ["乐器添加","配件添加","配件连接"]
		  },
		  {
		    "p" : "销售管理",
		    "c" : ["添加销售记录"]
		  },
		  {
		    "p" : "综合统计",
		    "c" : ["总入库","总出库","销售记录","帐务情况"]
		  },
		  {
		    "p" : "会员管理",
		    "c" : ["会员信息"]
		  },
		  {
		    "p" : "系统设置",
		    "c" : ["修改密码"]
		  }
		]
		var navData = '';
		for(var i=0;i<navList.length;i++){
			navData+= "<li class='nav-item'><a href='javascript:;'><i class='my-icon nav-icon icon_1'></i><span>"+navList[i].p+"</span><i class='my-icon nav-more'></i></a><ul>"
			for(var w=0;w<navList[i].c.length;w++){
				navData+="<li><a href='javascript:;'><span>"+navList[i].c[w]+"</span></a></li>"
			}
			navData+="</ul></li>"
		}
		$('#aat').html(navData)
	})
</script>
<script src="../js/jquery-3.1.1.min.js"></script>

</body>
</html>