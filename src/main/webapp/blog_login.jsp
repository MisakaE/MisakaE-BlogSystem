<%--
  Created by IntelliJ IDEA.
  User: MisakaE
  Date: 2022/12/25
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC>
<html>
    <head>
        <title>MisakaE</title>
        <script src="functions/js/usermanger.js" type="text/javascript"></script>
        <script src="functions/js/mySTL.js" type="text/javascript"></script>
    </head>

    <body>
        <form action="login" method="post" id="LoginForm">
            Username: <input type="text" id="Username" name="username"><br>
            Password: <input type="password" id="Password" name="password"><br>
            <span id="msg" style="color: red"></span><br>
            <input type="button" value="登录" onclick="checklogin()"><br>
        </form>
    </body>
</html>
