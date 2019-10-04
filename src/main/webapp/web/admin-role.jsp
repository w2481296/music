<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

</head>
<body>

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 权限管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="cl pd-5 bg-1 bk-gray"> <span class="l"><a class="btn btn-primary radius" href="javascript:;" onclick="admin_role_add('添加角色','../main/showIndex34.do','800')"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a> </span></div>
			<div class="mt-10">
			<table class="table table-border table-bordered table-hover table-bg">
				<thead>
					<tr>
						<th scope="col" colspan="6">权限管理</th>
					</tr>
					<tr class="text-c">
						<th width="25"><input type="checkbox" value="" name=""></th>
						<th width="40">ID</th>
						<th width="200">角色名</th>
						<th width="300">描述</th>
						<th width="70">操作</th>
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
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$.ajax( {
	    url : '../vip/selectrole.do',
	    type : 'post',
	    success : function(result) {
	        var navData = ''; //定义变量存储
	        for(var i=0;i<result.length;i++){
	        	navData+="<tr class='text-c'><td><input type='checkbox' value='"+result[i].id+"'></td>"
	        	navData+="<td>"+result[i].id+"</td>";
	        	navData+="<td>"+result[i].rolename+"</td>";
	        	navData+="<td>"+result[i].remake+"</td>";
	        	navData+="<td class='f-14'><a title='编辑' href='javascript:;' onclick='edit("+result[i].id+")' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6df;</i></a> <a title='删除' href='javascript:;' onclick='admin_role_del(this,"+result[i].id+")' class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a></td></tr>";
	        }
	        $('#table-data').html(navData);
	    }
	});
});
/*管理员-角色-添加34*/
function admin_role_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-编辑33*/
function edit(id){
	localStorage.setItem("roleid",id);
	layer_show('权限编辑','../main/showIndex33.do');
	
}
/*管理员-角色-删除*/
function admin_role_del(obj,id){
		layer.confirm('确认要删除吗？',{
			btn: ['确定', '取消']
		  },function(index){
				var params={
						vipid:id
				};
				$.ajax({
					url :"../vip/delroleById.do",
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
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>