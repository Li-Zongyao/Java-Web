<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="css/exam.css" />

    <title>exam</title>
</head>


<jsp:useBean id="exam" scope="session" class="com.beans.standardTest.Exam"/>



<body bgcolor="#FBFBFB">
        <form action="exam" method="post" >
        <div class="Main_Frame">
            <div class = "Text_Frame">
                <jsp:getProperty name="exam" property="result" />
            </div>

            <div class = "Submit_Frame_1" >
                <input type="submit" id="Submit_Button_1" value="提&nbsp交" onclick="displayInformation()" />
            </div>

        </div>
</form>
</body>
</html>
