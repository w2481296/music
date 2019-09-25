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
<iframe id="mainContent"  src="showIndexx.do" scrolling="no" width="1350px" height="650px" style="margin-left: 179px;margin-top: 64px;overflow-x:hidden;"></iframe>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
var id=${user.id};
$.ajax( {
    url : '../user/selectMenu.do',
    data:'id='+id,
    type : 'post',
    success : function(result) {
        var navData = ''; //定义变量存储
        var change=false;
        for(var i=0;i<result.length;i++){
	         if(result[i].menu_pid == 0&&change!=false){
	         		 navData+="</ul></li>";
	         }
        	 if(result[i].menu_pid == 0){
        		 navData+= "<li class='nav-item'><a href='javascript:;'><i class='my-icon nav-icon icon_1'></i><span>"+result[i].menu_name+"</span><i class='my-icon nav-more'></i></a><ul>";
        		continue;
        	 }
			 navData+="<li><a  href='javascript:;' _link='"+result[i].menu_url+"'><span>"+result[i].menu_name+"</span></a></li>";
			 change=true;
		}
        $('#aat').html(navData);
    }
});
	/* $(function(){
		var navList = [
		  {
		    "p" : "乐器管理"
		  },
		  {
		    "p" : "入库管理"
		  },
		  {
		    "p" : "销售管理"
		  },
		  {
		    "p" : "综合统计"
		  },
		  {
		    "p" : "会员管理"
		  },
		  {
		    "p" : "系统设置"
		  }
		]
		var navData = '';
		for(var i=0;i<navList.length;i++){
			 navData+= "<li class='nav-item'><a href='javascript:;'><i class='my-icon nav-icon icon_1'></i><span>"+navList[i].p+"</span><i class='my-icon nav-more'></i></a><ul>";
				if(i==0){
						navData+="<li><a  href='javascript:;' _link='showIndex1.do'><span>主乐器管理</span></a></li><li><a  href='javascript:;' _link='showIndex2.do'><span>配件管理</span></a></li>";
				}else if(i==1){
						navData+="<li><a  href='javascript:;' _link='showIndex3.do'><span>采购乐器</span></a></li><li><a  href='javascript:;' _link='showIndex4.do'><span>采购配件</span></a></li>";
				}else if(i==2){
						navData+="<li><a  href='javascript:;' _link='showIndex6.do'><span>销售记录</span></a></li>";
				}else if(i==3){
						navData+="<li><a  href='javascript:;' _link='showIndex7.do'><span>入库汇总</span></a></li><li><a  href='javascript:;' _link='showIndex8.do'><span>出库汇总</span></a></li><li><a href='javascript:;' _link='showIndex24.do'><span>汇总记录</span></a></li><li><a  href='javascript:;' _link='showIndex25.do'><span>账务情况</span></a></li>";
				}
				else if(i==4){
						navData+="<li><a  href='javascript:;' _link='showIndex11.do'><span>会员信息</span></a></li>";
				}
				else if(i==5){
						navData+="<li><a href='javascript:;' _link='showIndex27.do'><span>用户信息	</span></a></li><li><a href='javascript:;' _link='showIndex12.do'><span>修改密码</span></a></li><li><a href='javascript:;' _link='showIndex26.do'><span>登陆日志</span></a></li>";
				}
				navData+="</ul></li>";
			}
		$('#aat').html(navData);
	}) */
</script>
</body>
</html>