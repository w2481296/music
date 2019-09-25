<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />

</head>
<body>
<article class="cl pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="roleName" name="roleName" datatype="*4-16" nullmsg="用户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">权限选择：</label>
			<div class="formControls col-xs-8 col-sm-9" id="text-data">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="submit" style="margin-left: 110px;width: 200px;" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i>添加角色</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.page.js"></script> 

<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(document).ready(function () {
	$.ajax( {
	    url : '../vip/selectmenu.do',
	    type : 'post',
	    success : function(result) {
	    	var navData = ''; //定义变量存储
	    	var change=false;
	        for(var i=0;i<result.length;i++){
	        	if(result[i].menu_pid == 0&&change!=false){
	         		 navData+="</dl></dd></dl>";
	        	}
	        	if(result[i].menu_pid == 0){
	        		 navData+='<dl class="permission-list" ><dt><label><input type="checkbox" value="'+result[i].menu_id+'" name="user-Character-0" id="user-Character-0" onclick="checkAll(this)">'+result[i].menu_name+'</label></dt><dd><dl class="cl permission-list2">';
	        		 continue;
	        	}
				navData+='<dt><label><input type="checkbox" value="'+result[i].menu_id+'" name="user-Character-0-0" id="user-Character-0-0">'+result[i].menu_name+'</label></dt>'
				change=true;
	        }
	        $('#text-data').html(navData);
	    }
	});

});
	function checkAll(obj){
		if($(obj).prop("checked")){
			$(obj).closest("dl").find("dd dl input").prop("checked",true);
		}else{
			$(obj).closest("dl").find("dd dl input").prop("checked",false);
		}
		
	}
	function addrole(){
		var i = 0;
	    $( '#text-data input:checkbox' ).each( function(){
	        if( $( this ).is( ':checked' ) ){
	            i++;
	        }
	    } );
		if(i == 0 ){
	        alert( '至少选择一个权限!' );
	    }else{
	        return true;
	    } 
	}
	
	 $("#form-admin-role-add").validate({
		rules:{
			roleName:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			if(addrole()){
				alert("成功");
			};
			/* $(form).ajaxSubmit(); */
			/* var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index); */
		}
	}); 

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>