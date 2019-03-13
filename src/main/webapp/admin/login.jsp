<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/IconExtension.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	
		$(function(){
			
			$('#username').textbox({
				prompt:'请输入用户名',
				required:true,
			});
			
			$('#password').passwordbox({
				required:true,
				prompt:'请输入密码',
				validType:'length[6,32]'
			});
			
			$('#clientCode').textbox({
				prompt:'请输入验证码',
				required:true,
				/* validType:'length[4,4]' */
			});
			
			//  form 表单提交
			$("#loginForm").form({    
			    url:'${pageContext.request.contextPath}/admin/login.do',    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit;    
			        return true;
			    },    
			    success:function(data){ 
			    	//一定要jsonparse，否则会点不出来
			    	/* data = JSON.parse(data); */
			    	if(data == "ok"){
			    		location.href='${pageContext.request.contextPath}/main/main.jsp';
			    	}else{
			    		$("#message").empty();
			        	$("#message").append('<font color=red>'+data+'</font>');
			    	}
			    	
			    }    
			}); 
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" /> 
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="username" type="text"  name="adminName" class="text" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="password" type="password" name="password" class="text" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input  type="text" id="clientCode" name="clientCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/admin/generateCaptcha.do" 
									onclick="this.src='${pageContext.request.contextPath }/admin/generateCaptcha.do;date='+new Date()"/>
							</td>
						</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td><span id="message"></span></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
							<input type="button" class="loginButton" value="注册" onclick="location.href='${pageContext.request.contextPath}/admin/regist.jsp'">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>