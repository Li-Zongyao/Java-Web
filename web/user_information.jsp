<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/user_information.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<jsp:useBean id="user" type="com.beans.user.NormalUser" scope="session" />
<body>
	<div class="TopBar">
		<div class="TopBar_Name" >
			尊敬的&nbsp
			<jsp:getProperty name="user" property="name"/>
			&nbsp您好
		</div>
	
		<div class="TopBar_logout" >
			<a href="index.jsp" >注销</a>
		</div>
	</div>
	
	<div class="Frame_1">
		<div class="navigation">
			<table align="left" class="navigation_table"  cellspacing="2">
				<tr>
					<td class="Navigation_Table_Cell">
						<a href="HomeWorkSelect.jsp" target="Target_Frame">作业选择</a>
					</td>
				</tr>
				<tr>
					<td class="Navigation_Table_Cell">
						<a href="exam.jsp" target="Target_Frame">调查问卷</a>
					</td>
				</tr>

				<tr>
					<td class="Navigation_Table_Cell">
						<a href="show_information.jsp"  target="Target_Frame">基本信息</a>
					</td>
				</tr>

				<tr>
					<td class="Navigation_Table_Cell">
						<a href="update_password.jsp" target="Target_Frame">更换密码</a>
					</td>
				</tr>

				<tr>
					<td class="Navigation_Table_Cell">
						<a href="#"  target="Target_Frame">更换昵称</a>
					</td>
				</tr>

				<tr>
					<td class="Navigation_Table_Cell">
						<a href="#"  target="Target_Frame">添加好友</a>
					</td>
				</tr>

				<tr>
					<td class="Navigation_Table_Cell">
						<a href="#"  target="Target_Frame">上传文件</a>
					</td>
				</tr>
			</table>
		</div>

		<div class="fream_content">
			<iframe id="Frame_Main" frameborder="0" name="Target_Frame" src="HomeWorkSelect.jsp" />
		</div>

	</div>


	
	
</body>
</html>