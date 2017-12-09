<%--
  Created by IntelliJ IDEA.
  User: 1993
  Date: 2017/12/9
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账号</title>
    <link rel="stylesheet" type="text/css" href="css/register_user.css" />
</head>
<body bgcolor="#FBFBFB">
    <div class="Main_Frame">
        <form action="Register" method="post">

            <div class="Text_Frame">
                用户ID：<input type="text"  name="user_id" class="Text_Area"  value=""/>
            </div>

            <div class="Text_Frame">
                用户名：<input type="text"  name="name" class="Text_Area" value=""/>
            </div>

            <div class="Text_Frame">
                密码：<input type="password"  name="password" class="Text_Area"/>
            </div>

            <div class="Text_Frame">
                性别：

                <div class="Sex_Frame_2">
                    女<input type="radio"  name="sex" class="Radio_Frame" value="女"/>
                </div>

                <div class="Sex_Frame_1">
                    男<input type="radio"  name="sex" class="Radio_Frame" value="男"/>
                </div>

            </div>

            <div class="Text_Frame">
               年龄：<input type="text"  name="age" class="Text_Area" value=""/>
            </div>

            <div class = "Submit_Frame" >
                <input type="submit" class="Submit_Button" value="提&nbsp;交" >
            </div>

        </form>
    </div>
</body>
</html>
