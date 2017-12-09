<%--
  Created by IntelliJ IDEA.
  User: 1993
  Date: 2017/11/29
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/HomeworkSelect.css" />
    <title>Title</title>
</head>

<jsp:useBean id="homework" scope="session" class="com.beans.homeworkSelect.HomeworkSelect"/>
<body bgcolor="#FBFBFB">
    <form action="SelectHomework" method="post" >
        <div class="Main_Frame">
             <div class="Main_Content">
                 <jsp:getProperty name="homework" property="homeworkContent"/>
             </div>

             <div class="Submit_Frame" >
                <input type="submit" class="Submit_Button" value="开始选题" />
             </div>
        </div>

    </form>
</body>
</html>
