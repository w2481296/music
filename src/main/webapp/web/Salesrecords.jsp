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
<section class="Hui-article-box">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 综合统计 <span class="c-gray en">&gt;</span>汇总记录<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c"> 日期范围：
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d'})" id="datemin" class="input-text Wdate" style="width:120px;">
				-
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
				<input type="text" class="input-text" style="width:250px" placeholder="输入关键词" id="insname" name="">
				<button type="submit" class="btn btn-success radius" id="search" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
				<button type="submit" class="btn btn-success radius" id="clean" name="" style="width:70px">清空</button>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort" id="DataTables_Table_0">
					<thead>
						<tr class="text-c">
							<th style="width:50px">ID</th>
							<th style="width:80px">名称</th>
							<th style="width:80px">类型</th>
							<th style="width:80px">规格</th>
							<th style="width:70px">成本(元)</th>
							<th style="width:70px">售价(元)</th>
							<th style="width:70px">数量(件)</th>
							<th style="width:100px">厂商</th>
							<th style="width:100px">入库/出库</th>
							<th style="width:150px">仓库变动时间</th>
						</tr>
					</thead>
					<tbody id="table-data">
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script> 
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
 $(document).ready(function () {
    $('#DataTables_Table_0').DataTable({
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
                url: "../total/queryallstock.do",
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
            {'data': 'id'},
            {'data': 'inName'},
            {'data': 'inType'},
            {'data': 'inSpecifications'},
            {'data': 'inCost'},
            {'data': 'inPricing'},
            {'data': 'inQty'},
            {'data': 'inManufacturers'},
            {'data': 'instock'},
            {'data': 'inCreatetime'},
        ],
        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull)            {                    //列样式处理
        }
    })
});

/*-查询功能*/
$("#search").click(function(){
	var datatable = $("#DataTables_Table_0").dataTable();
	        if (datatable) {  
	         datatable.fnClearTable();    //清空数据
	         datatable.fnDestroy();         //销毁datatable
	 } 
	var tablebody = $('.DataTables_Table_0').find('tbody');
	tablebody.children().remove();
	
	 $('#DataTables_Table_0').DataTable({
	        serverSide: false, //启用服务器端分页
	        searching: false, //禁用原生搜索
	        pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
	        ajax: function (data, callback, settings) { 
		        //封装请求参数
		        var insname=$("#insname").val();
		    	var datemin=$("#datemin").val();
		    	var datemax=$("#datemax").val();
		    	console.log("=="+insname);
		    	var param={
		    			insName:insname,
		    			insTime1:datemin,
		    			insTime2:datemax
		    	};
	            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
	            param.start = data.start;//开始的记录序号
	            param.currentPage = (data.start / data.length) + 1;//当前页码
	            $.ajax({
	                type: "post",
	                url: "../total/queryallstock.do",
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
	            {'data': 'id'},
	            {'data': 'inName'},
	            {'data': 'inType'},
	            {'data': 'inSpecifications'},
	            {'data': 'inCost'},
	            {'data': 'inPricing'},
	            {'data': 'inQty'},
	            {'data': 'inManufacturers'},
	            {'data': 'instock'},
	            {'data': 'inCreatetime'},
	        ],
	        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull)            {                    //列样式处理
	        }
	    })
	
});	


/* 清空按钮 */
$("#clean").click(function(){
	$("#datemin").val("");
	$("#datemax").val("");
	$("#insname").val("");
});

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>