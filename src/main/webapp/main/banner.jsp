<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="${path}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${path}/themes/IconExtension.css">   
	<script type="text/javascript" src="${path}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${path}/js/jquery.easyui.min.js"></script>  
	<script type="text/javascript" src="${path}/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${path}/js/datagrid-detailview.js"></script> 
	

<body>
		<table id="dg"></table> 
		<!-- 添加轮播图 -->
       	<div style="display:none;padding:30px " id="addDialog">
       		<form id="addFom" method="POST" enctype="multipart/form-data" >
       			<table>
       				<tr>
       					<td>
			       			图片名称：
       					</td>
       					<td>
       						<input type="text" name="title" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				<tr>
       					<td>
			       			图片描述：
       					</td>
       					<td>
       						<input type="text" name="desc" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				<tr>
       					<td>
			       			请选择图片：
       					</td>
       					<td>
	       					<input type="file" name="upload" id="upload" style="width:300px;height:30px" class="easyui-validatebox" data-options="required:true"/>
	       					  
       					</td>
       				</tr>
       				
       				
       			</table>
       		</form>
       </div>
	
		<script type="text/javascript">
		
		
		
		$(function(){
			$('#dg').datagrid({    
			    url:'${path}/Banner/queryAllBanner.do',
			    //加入分页工具栏
			    pagination:true,
			    pagePosition:'bottom',
			    singleSelect:true,
			    fit:true,
			    columns:[[    
			        {field:'title',title:'标题',width:180},    
			        {field:'imgPath',title:'图片',width:180}, 
			        {field:'desc',title:'图片描述',width:180},
			        {field:'status',title:'图片状态',width:180,
			        	 formatter:function(value,rec){
			        		return '<input style="text-align: center" onchange="changeStatus(this)" value="'+value+'"/>';
			        	} 	
			        },
			        {field:'option',title:'操作',width:180,
			        	formatter:function(value,rec){
			        		return '<div class="easyui-linkbutton" onclick="deleteRow()"  style="text-align:center">删除</div>';
			        	}	
			        },
			    ]],
			    view:detailview,
			    detailFormatter:function(rowIndex,rowData){
			    	return '<table><tr>' + 
			    	'<td rowspan=2 style="border:0"><img src="${path}/img/upload/' + rowData.imgPath + '" style="height:100px;"></td>' + 
			    	'<td style="border:0">' + 
			    	'<p>名称: ' + rowData.title + '</p>' + 
			    	'<p>描述: ' + rowData.desc + '</p>' + 
			    	'<p>时间: ' + rowData.createTime + '</p>' + 
			    	'</td>' + 
			    	'</tr></table>'; 
			    },
			    toolbar:[{
			    	iconCls:'icon-add',
			    	text:'添加',
			    	handler:function(){
			    		$("#addDialog").dialog({    
						    title: '添加轮播图',    
						    width: 500,    
						    height: 300,    
						    buttons:[
						             	{
						             		text:'提交',
						             		handler:function(){
						             			$('#addFom').form('submit',{
						             				url:'${path}/Banner/add.do',
						             				type:'post',
						             				success:function(){
						            		            $.messager.show({  title:'提示',
			            		                            msg: '上传成功',
			            		                           	icon:'info',
			            		                    	});
						             					$('#addDialog').dialog('close');
						             					$('#dg').datagrid('load');
						             				}
						             			});
						             		}
						             	}
						             ]
						}); 
			    	}
			    }]
			});
		});
		
		
		//删除本行
		function deleteRow(){
			var selectRow = $('#dg').datagrid('getSelected');
			if(selectRow!=null){
				$.messager.alert({
					title:'警告',
					msg:'确认删除？',
					icon:'warning',
					fn:function(){
						$.get(
							"${path}/Banner/remove.do",
							"id="+selectRow.id,
							function(){
								$.messager.show({
									title:'提示',
									msg:'删除成功',
								});
								
								$('#dg').datagrid('reload');
							}
							
						);
					}
				});
			}
		};
		
		
		
		//修改状态
		function changeStatus(tag){
			var selectRow = $('#dg').datagrid('getSelected');
			if(selectRow!=null){
				$.messager.alert({
					title:'警告',
					msg:'确认修改？',
					icon:'warning',
					fn:function(){
						$.get(
							"${path}/Banner/update.do",
							"id="+selectRow.id+"&status="+tag.value,
							function(){
								$.messager.show({
									title:'提示',
									msg:'修改成功',
								});
								
								//$('#dg').datagrid('reload');
							}
							
						);
					}
				});
			}
		};
		
		
	</script>

</head>
</body>
</html>