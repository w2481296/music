<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

<!--/meta 作为公共模版分离出去-->
<meta name="keywords" content="H-ui.admin v3.0">
<meta name="description" content="H-ui.admin v3.0">
</head>
<body>
		<h1>欢迎进入管理系统</h1>
		<div align="center">
   <script language="javascript">
   var my = new Date();
    
   function showc() {
    var k=1;
    var j=1;
    var today;
    var tomonth;
    var theday=1;//日期
    var max;
    var temp;
    var tempday;//这个月第一天的星期
    document.write ("<b>" + my.getFullYear() + "-" + (my.getMonth()+1) + "</b>");
    document.write ("<table border='1' width='273' height='158'>");
    document.write ("<tr>");
    document.write ("<td height='23' width='39'><font color='red'>Sun</font></td>");
    document.write ("<td height='23' width='39'>Mon</td>");
    document.write ("<td height='23' width='39'>Tue</td>");
    document.write ("<td height='23' width='39'>Wed</td>");
    document.write ("<td height='23' width='39'>Thu</td>");
    document.write ("<td height='23' width='39'>Fri</td>");
    document.write ("<td height='23' width='39'>Sat</td>");
    document.write ("</tr>");
    temp=my.getDate();
    my.setDate(1);
    //document.write (my.getDate());
    tempday=my.getDay();//返回第一天是星期几
    my.setDate(temp);
    today=my.getDay();//返回现在星期几
    
    switch ((my.getMonth()+1)) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
    max=31;
    break;
    case 4:
    case 6:
    case 9:
    case 11:
    max=30;
    break;
    default:
    max=29;//这里没有考虑闰月！！
    //document.write (max);
    }
    for(k=0;k<6;k++) {
    document.write ("<tr>");
    for(j=0;j<=6;j++) {
    document.write ("<td height='23' width='39'>");
    if(j>=(tempday)) {
    tempday=0;//设置为最小，相当于取消判断条件
    if(theday<=max) {
     document.write ("<a title=" + my.getFullYear() + "-" + (my.getMonth()+1) + "-" +theday + " target='_blank' href=detail.asp?date=" + theday + ">");
     if(theday==my.getDate())
     document.write ("<font color='green'>[" + theday + "]</font></a>");
     else if(j==0)
     document.write ("<font color='red'>" + theday + "</font></a>");
     else
     document.write (theday + "</a>");
     theday++;
    }
    }
    document.write ("</td>");
    }
    document.write ("</tr>");
    }
    document.write ("</table>");
   }
    
   showc();
  </script>
  </div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="../lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script type="text/javascript">

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>