<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<base href="http://localhost:8080/">
	<!-- 添加css样式 -->
	<link rel="stylesheet" type="text/css" href="css/index.css" />

<title>登录</title>
</head>
<body>
	<div class="login">
    	
      	<br />
        <div class="imagelogo">
	        <img src="image/0101.JPG" width="311" height="208" />
	    </div>
	    
        <form name="lgin" action="Login" method="post">
        	<!-- 
        	登录栏
        	 -->
	        <div class="account">
		        <img src="image/login.JPG" width="50" align="left" />
		        
		      	<input type="text" class="txt" maxlength="30"  size="30"  name="ac" 
		      	placeholder="请输入账号（长度不能低于8位）"/>
	        </div>
	        
	        <!-- 
	        密码栏
	         -->
	        <div class="password">
		        <img src="image/pass.jpg" width="50" height="63" align="left" />
		        
		        <input type="password" class="txt" maxlength="30"  size="30"
		         name="pw" 
		         placeholder="请输入密码（长度不能低于8位）" />
	        </div>
	        
	         <!-- 
	        登录按钮
	         -->

	        <div class="ok">
	       		<input type="submit" class="button" value="登&nbsp录"  />
	        </div>
	        
	        </form>

			<div class="Reg_Frame">
				<a href="register_user.jsp">注册新用户</a>
			</div>

	    </div>
</body>
</html>