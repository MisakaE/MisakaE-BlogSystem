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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="css/custom-css.css">
        <link rel="stylesheet" href="css/test.css">
    </head>

    <body>
    <!--
        <form action="login" method="post" id="LoginForm">
            Username: <input type="text" id="Username" name="username"><br>
            Password: <input type="password" id="Password" name="password"><br>
            <span id="msg" style="color: red"></span><br>
            <input type="button" value="登录" onclick="checklogin()"><br>
        </form>
    -->
    <div class="container">
        <form class="form-signin" action="login" method="post" id="LoginForm">
            <h2 class="form-signin-heading col-sm-auto">登录</h2>
            <label for="Username" class="sr-only">Username</label>
            <input type="text" id="Username" class="form-control" name="username" placeholder="用户名" required autofocus>
            <label for="Password" class="sr-only">Password</label>
            <input type="password" id="Password" class="form-control" name="password" placeholder="密码" required>
            <button type="submit" class="btn btn-primary col-md-6" onclick="checklogin()">登录</button>
            <button style="float:right" type="button" class="btn btn-outline-primary col-md-6">注册</button>
        </form>
    </div>
    </body>
</html>
