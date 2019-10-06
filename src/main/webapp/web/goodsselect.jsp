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

<style type="text/css">
table th, table td {
	text-align: center;
	vertical-align: middle !important;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
	text-align: center;
}

table td, table th {
	border: 1px solid #cad9ea;
	color: #666;
	height: 30px;
}

table thead th {
	background-color: #CCE8EB;
	width: 100px;
}

table tr:nth-child(odd) {
	background: #fff;
}

table tr:nth-child(even) {
	background: #F5FAFA;
}
</style>

<meta name="keywords" content="H-ui.admin">
<meta name="description" content="H-ui.admin">
</head>
<body>
	<div name="Bquery" id="Bquery" style="float: left;">
		<label style="margin-left: 77px; font-weight: bold; width: 172px;">商品查询</label>
		<input type="text" name="search" id="search" value="" /> <input
			type="button" name="query" id="query"
			style="margin-left: 10px; background: indianred; color: white; border-radius: 9px; width: 57px; border: 1px solid #eee;"
			value="查询" />
	</div>
	<input type="button" name="back" id="back" value="返回"
		style="background-color: indianred; margin-left: 10px; background: indianred; color: white; border-radius: 9px; width: 57px; border: 1px solid #eee;" />
	<table id="sparepartBom" border="1">
		<tr>
			<th>商品名称</th>
			<th>商品类型</th>
			<th>商品规格</th>
			<th>商品售价</th>
			<th style="display:none">商品成本</th>
			<th>商品库存</th>
			<th>商品厂家</th>
		</tr>
	</table>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<script type="text/javascript"
		src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="../lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="../lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
		
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#sparepartBom').DataTable({
	        serverSide: false, //启用服务器端分页
	        searching: false, //禁用原生搜索
	        pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
	        ajax: function (data, callback, settings) { 
		        //封装请求参数
		        var param = {};
	            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
	            param.start = data.start;//开始的记录序号
	            param.currentPage = (data.start / data.length) + 1;//当前页码
	            $.ajax({
	                type: "post",
	                url : "../out/selectgoodsorname.do",
	                cache: false, //禁用缓存
	                dataType: "json",
	                success: function (result) {
	                    var returnData = {};
	                    returnData.draw = data.startRow;//这里直接自行返回了draw计数器,应该由后台返回
	                    returnData.recordsTotal = result.totalRows;//返回数据全部记录
	                    returnData.recordsFiltered = result.totalRows;//后台不实现过滤功能，每次查询均视作全部结果
	                    returnData.data = result.items;//返回的数据列表
	                    //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
	                    callback(returnData);
	                }
	            });
	        },
	        "columns": [ 
	            {'data': 'outName'},
	            {'data': 'outType'},
	            {'data': 'outSpecifications'},
	            {'data': 'outPricing'},
	            {'data': 'outCost'},
	            {'data': 'outQty'},
	            {'data': 'outManufacturers'},
	        ],
	        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull)            {                    //列样式处理
	        }
	    })
	});
	/*-查询功能*/
	$("#query").click(function(){
		var datatable = $("#sparepartBom").dataTable();
		        if (datatable) {  
		         datatable.fnClearTable();    //清空数据
		         datatable.fnDestroy();         //销毁datatable
		 } 
		var tablebody = $('.sparepartBom').find('tbody');
		tablebody.children().remove();
		
		 $('#sparepartBom').DataTable({
		        serverSide: false, //启用服务器端分页
		        searching: false, //禁用原生搜索
		        pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
		        ajax: function (data, callback, settings) { 
			        //封装请求参数
			      	var insName2=document.getElementById('search').value;
					var param={
							outName:insName2
					}
		            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
		            param.start = data.start;//开始的记录序号
		            param.currentPage = (data.start / data.length) + 1;//当前页码
		            $.ajax({
		                type: "post",
		                url : "../out/selectgoodsorname.do",
		                cache: false, //禁用缓存
		                data:param,
		                dataType: "json",
		                success: function (result) {
		                    var returnData = {};
		                    returnData.draw = data.startRow;//这里直接自行返回了draw计数器,应该由后台返回
		                    returnData.recordsTotal = result.totalRows;//返回数据全部记录
		                    returnData.recordsFiltered = result.totalRows;//后台不实现过滤功能，每次查询均视作全部结果
		                    returnData.data = result.items;//返回的数据列表
		                    //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
		                    callback(returnData);
		                }
		            });
		        },
		        "columns": [ 
		    	            {'data': 'outName'},
		    	            {'data': 'outType'},
		    	            {'data': 'outSpecifications'},
		    	            {'data': 'outPricing'},
		    	            {'data': 'outCost'},
		    	            {'data': 'outQty'},
		    	            {'data': 'outManufacturers'},
		    	        ],
		    	        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull)            {                    //列样式处理
		    	        }
		    })
		
	});	
	
	
	/* 	$(document).ready(function() {
			selBomSparepart();
		});
		function selBomSparepart() {
			$
					.ajax({
						url : "../out/selectgoodsorname.do",
						type : "post",
						dataType : "json",
						contentType : "application/json;charset=utf-8",
						success : function(result) {
							console.log("==>" + result);
							var allNum = result.length;
							for (var i = 0; i < allNum; i++) {
								var outName = result[i].outName;
								var outType = result[i].outType != null ? result[i].outType
										: "";
								var outSpecifications = result[i].outSpecifications != null ? result[i].outSpecifications
										: "";
								var outPricing = result[i].outPricing != null ? result[i].outPricing
										: "";
								var outQty = result[i].outQty != null ? result[i].outQty
										: "";
								var outCost = result[i].outCost != null ? result[i].outCost
										: "";
								var outManufacturers = result[i].outManufacturers != null ? result[i].outManufacturers
										: "";
								htmlStr = '<tr ondblclick ="setCustomerNumber(this)">'
										+ '<td>'
										+ outName
										+ '</td>'
										+ '<td>'
										+ outType
										+ '</td>'
										+ '<td>'
										+ outSpecifications
										+ '</td>'
										+ '<td>'
										+ outPricing
										+ '</td>'
										+ '<td style="display:none">'
										+ outCost
										+ '</td>'
										+ '<td>'
										+ outQty
										+ '</td>'
										+ '<td>'
										+ outManufacturers + '</td>' + '</tr>';
								$("#sparepartBom").append(htmlStr);
							}
						}
					});
		}
		$("#query")
				.click(
						function() {
							$('#sparepartBom tbody').empty();

							var insName2 = document.getElementById('search').value;
							var params = {
								outName : insName2
							}
							$
									.ajax({

										url : "../out/selectgoodsorname.do",
										type : "post",
										data : params,
										success : function(result) {
											var allNum = result.length;
											var htmlStr = "<tr><th style='display:none'>商品id</th><th>商品名称</th><th>商品类型</th><th>商品规格</th><th>商品售价</th><th style='display:none'>商品成本</th><th>商品库存</th><th>商品厂家</th></tr>";
											$("#sparepartBom").append(htmlStr);
											for (var i = 0; i < allNum; i++) {
												var outName = result[i].outName;
												var outType = result[i].outType != null ? result[i].outType
														: "";
												var outSpecifications = result[i].outSpecifications != null ? result[i].outSpecifications
														: "";
												var outPricing = result[i].outPricing != null ? result[i].outPricing
														: "";
												var outQty = result[i].outQty != null ? result[i].outQty
														: "";
												var outCost = result[i].outCost != null ? result[i].outCost
														: "";
												var outManufacturers = result[i].outManufacturers != null ? result[i].outManufacturers
														: "";
												htmlStr = '<tr ondblclick ="setCustomerNumber(this)">'
														+ '<td>'
														+ outName
														+ '</td>'
														+ '<td>'
														+ outType
														+ '</td>'
														+ '<td>'
														+ outSpecifications
														+ '</td>'
														+ '<td>'
														+ outPricing
														+ '</td>'
														+ '<td style="display:none">'
														+ outCost
														+ '</td>'
														+ '<td>'
														+ outQty
														+ '</td>'
														+ '<td>'
														+ outManufacturers + '</td>' + '</tr>';
												$("#sparepartBom").append(htmlStr);
											}
										}
									});
						}) */
		//返回逻辑
		$("#back").click(function() {
			layer_close();
		})
		/**
		 * 配件点击事件
		 */
		 $('#sparepartBom').on('click', 'tr',function() {
			    var myTable = $('#sparepartBom').DataTable();
			    var data = myTable.row(this).data(); //获取单击那一行的数据
				var id=data.id;
				var outCost=data.outCost;
				var outName=data.outName;
				var outType=data.outType;
				var outSpecifications=data.outSpecifications;
				var outPricing=data.outPricing;
				var outQty=data.outQty;
				var outManufacturers=data.outManufacturers;
				window.parent.CallMoney(outCost,outName, outType, outSpecifications,
						outPricing, outQty, outManufacturers); 
				layer_close();
		 } );
		/* function setCustomerNumber(tr) {
			var sparepartBom = $(tr);
			var i = 0;
			var id;
			var outName;
			var outType;
			var outSpecifications;
			var outPricing;
			var outQty;
			var outManufacturers;
			sparepartBom.find("td").each(function() {
				if (i == 0) {
					outName = $(this).text();
				} else if (i == 1) {
					outType = $(this).text();
				} else if (i == 2) {
					outSpecifications = $(this).text();
				} else if (i == 3) {
					outPricing = $(this).text();
				} else if (i == 4) {
					outCost = $(this).text();
				} else if (i == 5) {
					outQty = $(this).text();
				}else if (i == 6) {
					outManufacturers = $(this).text();
				} else {
					return false;
				}
				i++;
			});
			window.parent.CallMoney(outCost,outName, outType, outSpecifications,
					outPricing, outQty, outManufacturers);
			layer_close();
		} */
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>