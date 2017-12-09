<%--
  Created by IntelliJ IDEA.
  User: 1993
  Date: 2017/11/16
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <base href="http://localhost:8080/UpdatePwdControlClass">
    <link rel="stylesheet" type="text/css" href="css/update_password.css" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>password</title>
</head>

<body bgcolor="#FBFBFB">

<form action="UpdatePwdServlet" method="post">
    <div class="Update_Pass_Frame">

        <div class="Text_Frame">
           旧密码：<input type="password"  name="oldPwd" class="Text_Area"/>
        </div>

        <div class="Text_Frame">
            新密码：<input type="password" name="newPwd" class="Text_Area"/>
        </div>

        <div class = "Submit_Frame" >
            <input type="submit" class="Submit_Button" value="提&nbsp;交" >
        </div>
    </div>

</form>

</body>
</html>
