<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
</head>
<body>
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
		<div style="width: 400; height: 195px; background-color:#19a89a; margin-left: 39px; margin-top: 19px;">
			<div>
				<span style="font-size: 40px; color: aliceblue; display: block; margin-left: 5px;">123155</span>
				<span  style="color: aliceblue;  margin-left: 40px;">库存总数</span>
			</div>
			<div>
				<span style="font-size: 40px; color: aliceblue; display: block;margin-left: 5px;">516516</span>
				<span  style="color: aliceblue;  margin-left: 40px;">库存成本</span>
			</div>
			<img style="width: 173px; margin-left: 200; margin-top: -166px;" src="../images/goods.png">
		</div>
		<div style="width: 400; height: 195px; background-color: indianred; margin-left: 468px; margin-top: -196px;">
			<div>
				<span style="font-size: 40px; color: aliceblue; display: block; margin-left: 5px;">123155</span>
				<span  style="color: aliceblue;  margin-left: 40px;">今日销售</span>
			</div>
			<div>
				<span style="font-size: 40px; color: aliceblue; display: block;margin-left: 5px;">516516</span>
				<span  style="color: aliceblue;  margin-left: 40px;">销售金额</span>
			</div>
			<img style="width: 173px; margin-left: 200; margin-top: -166px;" src="../images/money.png">
		</div>
		 <div id="time" style="width: 400px; position: absolute; right: 40px; top: 58px;"></div>
		 
		 <div style="margin-top: 25px;width: 30%; color: aliceblue;background-color: #4e9dec; margin-left: 35px;">
		 	<img style="width: 17px;margin-left: 10px; margin-top: -5px;" src="../images/bei.png">
		 	商店出售最多乐器TOP5
		 </div>
		 <table class="table table-border table-bordered table-hover table-bg table-sort" id="tongji1" style="width: 30%;  margin-left: 35px;">
					<thead>
						<tr class="text-c">
							<th style="width:50px">排名</th>
							<th style="width:80px">商品名称</th>
							<th style="width:80px">数量</th>
							<th style="width:80px">售价</th>
						</tr>
					</thead>
					<tbody id="table-data">
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
					</tbody>
		</table>
		 <div style="margin-left: 470px;margin-top: -244px;color: aliceblue;width: 30%;background-color: #4e9dec;">
		 	<img style="width: 17px; margin-left: 7px; margin-top: -2px;" src="../images/bei.png">
		 	商店采购最多乐器TOP5
		 </div>
		 <table class="table table-border table-bordered table-hover table-bg table-sort" id="tongji2" style="margin-left: 470px; width: 30%;">
					<thead>
						<tr class="text-c">
							<th style="width:50px">排名</th>
							<th style="width:80px">商品名称</th>
							<th style="width:80px">数量</th>
							<th style="width:80px">售价</th>
						</tr>
					</thead>
					<tbody id="table-data">
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
						<tr>
							<td>1</td>
							<td>吉他</td>
							<td>22</td>
							<td>500</td>
						</tr>
					</tbody>
		</table>
		 
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/My97DatePicker/4.8/calendar-3.1.js"></script> 
<!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	calendar_init($("#time"),{
        title_color:"aliceblue",
        title_bg_color:"#2568a5",
        day_color:"aliceblue",
        day_bg_color:"#3e97e9",
        date_bg_color:"#3e97e9",
        date_color:"aliceblue",
        date_active_color:"#2c4264",
        line_height:"60"
    });//在id=test的DIV中显示日历
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>