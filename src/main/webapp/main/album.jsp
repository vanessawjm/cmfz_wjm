<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	
	<script type="text/javascript">
		$(function(){
			$('#tt').treegrid({    
			    url:'${pageContext.request.contextPath}/Album/queryAll.do',    
			    idField:'id',    
			    treeField:'title',  
			    fitColumns:true,
			    
			    columns:[[    
			        {title:'章节名称',field:'title',width:100},    
			        {field:'size',title:'音频大小',width:100},    
			        {field:'createTime',title:'上传时间',width:100},    
			        {field:'duration',title:'音频时长',width:100}    
			    ]],
			    toolbar: [{
			    	text:'查看专辑详情',
					iconCls: 'icon-add',
					handler: function(){
						var selRow = $('#tt').treegrid('getSelected');
						if(selRow){
							$('#title1').html(selRow.title);
							$('#score1').html(selRow.score);
							$('#brodcast1').html(selRow.brodcast);
							$('#author1').html(selRow.author);
							$('#publicTime1').html(selRow.publicTime);
							$('#count1').html(selRow.count);
							$('#coverImg1').html(selRow.coverImg);
							$('#status1').html(selRow.status);
							$('#desc').dialog({    
							    title: 'My Dialog',    
							    width: 400,    
							    height: 300,    
							});  
							
						}else{
							$.messager.alert({  title:'警告',
	                            msg: '请先选择您要查看的专辑',
	                           	icon:'warming',
	                    	});
						}
					}
				},'-',{
					text:'添加专辑',
					iconCls: 'icon-add',
					handler: function(){
						$('#addAlbum').dialog({
							title:'添加专辑',
							width:500,
							height:400,
							buttons:[
							         {
							        	 text:'提交',
										 handler:function(){
											 $('#addAlbumForm').form('submit',{
						             				url:'${path}/Album/insertAlbum.do',
						             				type:'post',
						             				success:function(){
						            		            $.messager.show({  title:'提示',
			            		                            msg: '上传成功',
			            		                           	icon:'info',
			            		                    	});
						             					$('#addAlbum').dialog('close');
						             					$('#tt').treegrid('load');
						             				}
						             			}); 
										 }							        	 
							         }
							         ]
						});
					}
				},'-',{
					text:'添加章节',
					iconCls: 'icon-add',
					handler: function(){
						var selRow = $('#tt').treegrid('getSelected');
						if(selRow){
							$('#id').val(selRow.id);
							$('#addChapter').dialog({
								title:'添加章节',
								width:500,
								height:400,
								buttons:[
								         {	
								        	text:'提交',
								         	handler:function(){
								         		$('#addChapterForm').form('submit',{
						             				url:'${path}/chapter/addChapter.do',
						             				type:'post',
						             				success:function(){
						            		            $.messager.show({  title:'提示',
					    		                            msg: '上传成功',
					    		                           	icon:'info',
					    		                    	});
						             					$('#addChapter').dialog('close');
						             					$('#tt').treegrid('load');
						             				}
						             			}); 
								         	}		
								         }
								        ]
							});
							
							
						}else{
							$.messager.alert({  title:'警告',
	                            msg: '请先选择您要查看的专辑',
	                           	icon:'warming',
	                    	});
						}
					}
				},'-',{
					text:'下载',					
					iconCls: 'icon-help',
					handler: function(){
						var selRow = $('#tt').treegrid('getSelected');
						if(selRow!=null || selRow.size!=null){
							console.log(selRow.url);
							location.href='${path}/chapter/downFile.do?name='+selRow.url; 
							
						}else{
							$.messager.alert({
								title:'警告',
								msg:'请先选择一个专辑',
								icon:'warning',
							});
						}
					}
				}]

			});  
		});
	
	</script>
<table id="tt" ></table> 

<!-- 专辑详情 -->
<div id="desc" style="display:none;padding:30px ">
	<table cellspacing="0" border="1" width="300px" align="center" style="font-size: 16px">
		<tr>
			<td>专辑名称</td>
			<td id="title1"></td>
		</tr>
		<tr>
			<td>专辑评价</td>
			<td id="score1"></td>
		</tr>
		<tr>
			<td>播音人</td>
			<td id="brodcast1"></td>
		</tr>
		<tr>
			<td>作者</td>
			<td id="author1"></td>
		</tr>
		<tr>
			<td>简介</td>
			<td id="brief1"></td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td id="publicTime1"></td>
		</tr>
		<tr>
			<td>集数</td>
			<td id="count1"></td>
		</tr>
		<tr>
			<td>封面</td>
			<td id="coverImg1"></td>
		</tr>
		<tr>
			<td>状态</td>
			<td id="status1"></td>
		</tr>
	</table>
</div>  

<!-- 添加专辑 -->
<div style="display:none;padding:30px " id="addAlbum">
       		<form id="addAlbumForm" method="POST" enctype="multipart/form-data" >
       			<table>
       				<tr>
       					<td>
			       			专辑名称：
       					</td>
       					<td>
       						<input type="text" name="title" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				<tr>
       					<td>
			       			播音员名称：
       					</td>
       					<td>
       						<input type="text" name="brodcast" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				<tr>
       					<td>
			       			作者名称：
       					</td>
       					<td>
       						<input type="text" name="author" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				<tr>
       					<td>
			       			章节集数：
       					</td>
       					<td>
       						<input type="text" name="count" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				<tr>
       					<td>
			       			专辑简介：
       					</td>
       					<td>
       						<input type="textarea" name="brief" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				
       				<!-- <tr>
       					<td>出版时间</td>
       					<td>
       						<input type="text" name="publicTime" class= "easyui-datetimebox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr> -->
       				<tr>
       					<td>
			       			封面图片：
       					</td>
       					<td>
	       					<input type="file" name="upImg"  style="width:300px;height:30px" class="easyui-validatebox" data-options="required:true"/>
       					</td>
       				</tr>
       				
       				
       			</table>
       		</form>
       </div>

<!-- 添加章节 -->
<div style="display:none;padding:30px " id="addChapter">
       		<form id="addChapterForm" method="POST" enctype="multipart/form-data" >
       			<table>
       				
       				<tr>
       					<td>
			       			章节名称：
       					</td>
       					<td>
       						<input style="display:none" name="albumId" id="id" />
       						<input type="text" name="title" class="easyui-textbox" data-options="required:true" style="width:300px;height:30px"/>
       					</td>
       				</tr>
       				<tr></tr>
       				
       				<tr>
       					<td>
			       			音频文件：
       					</td>
       					<td>
	       					<input type="file" name="upFile"  style="width:300px;height:30px" class="easyui-validatebox" data-options="required:true"/>
       					</td>
       				</tr>
       				
       				
       			</table>
       		</form>
       </div>


