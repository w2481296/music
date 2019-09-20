<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
	<form action="../in/downloadExcel.do" method="POST">
			<div class="layui-form-item">
			<label class="layui-form-label">下载模板:</label>
			<div class="layui-input-inline" style="margin-left: 80px;margin-top: -20px;">
				<input class="layui-btn " type="submit" value="下载模板">
			</div>
			</div>
	</form>
	<div class="page-container">
		<div class="form-group" id="thumbnailUploadContainer" class="col-sm-10" style="float: left; margin-right: 50px;">
			<input id="articleImageFile" name="excelFile" type="file" class="form-control" style="width: 300px;display: inline;margin-top: 15px;" />
			<input id="saveZipButton" type="button" style="width: 130px; height: 35px;margin-top: 20px;" value="批量导入Excel数据" />
	</div>
	<div>
		<label style="margin-left: 135px; margin-top: 10px;">注意事项:</label>
	</div>
	
	<div class="layui-input-block">
		<span style="color: red"></br>1、请根据模板填写数据。</br>2、非必填列不要删除。</br>3、不要调整各个列的先后顺序。</span>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
	$("#saveZipButton").on('click', function(){			
		  var formData = new FormData();
		    var name = $("#articleImageFile").val();
		    formData.append("file",$("#articleImageFile")[0].files[0]);
		    formData.append("name",name);//这个地方可以传递多个参数
		    formData.append("type","主乐器");//这个地方可以传递多个参数
		    $.ajax({
		        url :"../in/export.do",
		        type : 'POST',
		        async : false,
		        data : formData,
		        // 告诉jQuery不要去处理发送的数据
		        processData : false,
		        // 告诉jQuery不要去设置Content-Type请求头
		        contentType : false,
		        beforeSend:function(){
		            console.log("正在进行，请稍候");
		        },
		        success : function(data) {
		            if(data=="1"){
		                alert("导入成功");
		                parent.location.reload();
		    			layer_close();
		            }else{
		                alert("导入失败");
		            }
		        }
		    });
	});

	</script>
</body>
</html>