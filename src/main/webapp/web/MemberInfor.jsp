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
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

<!--/meta 作为公共模版分离出去-->
<meta name="keywords" content="H-ui.admin v3.0">
<meta name="description" content="H-ui.admin v3.0">
</head>
<body>

<section class="Hui-article-box">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 会员管理 <span class="c-gray en">&gt;</span> 会员信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c"> 注册日期范围：
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d'})" id="datemin" class="input-text Wdate" style="width:120px;">
				-
				<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
				<input type="text" class="input-text" style="width:250px" placeholder="输入会员关键字" id="insname" name="">
				<button type="submit" class="btn btn-success radius" id="search" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
				<button type="submit" class="btn btn-success radius" id="clean" name="" style="width:70px">清空</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除会员</a> <a class="btn btn-primary radius" data-title="新增会员" _href="article-add.html" onclick="member_show('新增会员','../main/showIndex16.do','','400','500')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加会员</a></span></div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort" id="DataTables_Table_0">
					<thead>
						<tr class="text-c">
							<th style="width:10px"><input type="checkbox" name="" value=""></th>
							<th style="width:50px">ID</th>
							<th style="width:80px">名字</th>
							<th style="width:50px">性别</th>
							<th style="width:50px">年龄</th>
							<th style="width:100px">电话</th>
							<th style="width:80px">积分</th>
							<th style="width:150px">更新时间</th>
							<th style="width:150px">注册时间</th>
							<th style="width:50px">操作</th>
						</tr>
					</thead>
					<tbody id="table-data">
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>

<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
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
            	url :"../vip/selectVipInfo.do",
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
			{'data': 'null'}, 
            {'data': 'id'},
            {'data': 'vipName'},
            {'data': 'vipGender'},
            {'data': 'vipAge'},
            {'data': 'vipPhone'},
            {'data': 'vipIntegral'},
            {'data': 'vipUpdatetime'},
            {'data': 'vipCreatetime'},
            {'data': 'null'}, 
        ],
        "columnDefs" : [ {
        	"targets" : 9,//操作按钮目标列
        	"data" : null,
        	"render" : function(data, type,row) {
        	var id = row.id;
        	var html = '<a title='+"'编辑'"+' href="javascript:;" onclick="member_show('+"'编辑',"+"'../main/showIndex15.do',"+"'"+id+"'"+','+"'700',"+"'550'"+')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'+id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
        	return html;
      		}},
      		{
            	"targets" : 0,//操作按钮目标列
            	"data" : null,
            	"render" : function(data, type,row) {
            	var id =row.id;
            	var html = '<input type="checkbox" value="'+id+'" name="">';
            	return html;
            	}
            	}
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
		    			vipName:insname,
		    			vipTime1:datemin,
		    			vipTime2:datemax
		    	};
	            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
	            param.start = data.start;//开始的记录序号
	            param.currentPage = (data.start / data.length) + 1;//当前页码
	            $.ajax({
	                type: "post",
	                url :"../vip/selectVipInfo.do",
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
	        			{'data': 'null'}, 
	                    {'data': 'id'},
	                    {'data': 'vipName'},
	                    {'data': 'vipGender'},
	                    {'data': 'vipAge'},
	                    {'data': 'vipPhone'},
	                    {'data': 'vipIntegral'},
	                    {'data': 'vipUpdatetime'},
	                    {'data': 'vipCreatetime'},
	                    {'data': 'null'}, 
	                ],
	                "columnDefs" : [ {
	                	"targets" : 9,//操作按钮目标列
	                	"data" : null,
	                	"render" : function(data, type,row) {
	                	var id = row.id;
	                	var html = '<a title='+"'编辑'"+' href="javascript:;" onclick="member_show('+"'编辑',"+"'../main/showIndex15.do',"+"'"+id+"'"+','+"'700',"+"'550'"+')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'+id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
	                	return html;
	              		}},
	              		{
	                    	"targets" : 0,//操作按钮目标列
	                    	"data" : null,
	                    	"render" : function(data, type,row) {
	                    	var id =row.id;
	                    	var html = '<input type="checkbox" value="'+id+'" name="">';
	                    	return html;
	                    	}
	                    	}
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


/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',{
		btn: ['确定', '取消']
	  },function(index){
			var params={
					vipid:id
			};
			$.ajax({
				url :"../vip/delvipById.do",
				data : params,
				type:"post",
				async : false,
				success : function(result) {
					if(result=="success"){
						$(obj).parents("tr").remove();
					}else{
						alert("删除失败");
					}
				}
			});
			layer.closeAll('dialog'); 
	},function(){
		layer.closeAll('dialog'); 
	});
}
/*用户-批量删除*/
function datadel(){
	console.log("批量删除");
	var ptag_ids = new Array(); //定义一个数组存储id
	     // 循环获取选中的checkbox
	    $("#table-data input[type='checkbox']:checked").each(function() {
	        if (!isNaN($(this).val())) {
	            ptag_ids.push($(this).val()); // 把值push进入数组里面
	        }
	    });
	    if(ptag_ids.length ==0){
	        alert('请选择至少一条记录删除');
	        return false;
	    }
		console.log("选择得id"+ptag_ids);
	     //调用删除函数
	    deletePtag(ptag_ids);
	}

	 

	function deletePtag(ptag_ids){
	     if(confirm("您确定要删除次会员或者多条会员记录吗？删除后无法恢复,请谨慎操作！")){
	         $.ajax({
	             type : "post",
	             url : "../vip/delvipsByIds.do",
	             data : { "ids" : ptag_ids.toString() },  //数组.toString();转成字符串，号隔开的
	             success : function(data) {
	                 console.info(data);
	                 if(data=="success"){
	                     $("#btn-danger").prop("checked", false);//成功后把全选按钮设置成不选中，其他下面刷新了，要不要都可以的
	                     location.reload();
	                 }else{
	                     alert(data.msg);
	                 }
	             }
	         });
	     }
	}

	/*用户-查看*/
	function member_show(title,url,id,w,h){
		localStorage.setItem("vipeditId",id);
		layer_show(title,url,w,h);
	}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>