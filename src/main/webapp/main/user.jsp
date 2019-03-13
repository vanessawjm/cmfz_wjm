<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
</head>
<body>
	<table id="user"></table> 
	<script type="text/javascript">
	
	

	
	
	
		$(function(){
			$('#user').datagrid({    
			    url:'${pageContext.request.contextPath}/user/queryUsers.do',
			    fitColumns:true,
			    fit:true,
			    pagination:true,
			    pagePosition:'bottom',
			    toolbar: [{
					iconCls: 'icon-edit',
					text:'导出文档',
					handler: function(){
						location.href='${pageContext.request.contextPath}/user/download.do'; 
					}
				}],

			    columns:[[    
			        {field:'username',title:'法号',width:100},    
			        {field:'realname',title:'真实姓名',width:100},    
			        {field:'sex',title:'性别',width:100,}   , 
			        {field:'privoince',title:'省份',width:100,},  
			        {field:'city',title:'城市',width:100,}  ,
			        {field:'sign',title:'签名',width:100,},
			        {field:'phone',title:'手机号',width:100,},
			        
			    ]]    
			});  

		});
			
	</script> 
</body>
</html>