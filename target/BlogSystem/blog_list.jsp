<%@ page import="static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title" %><%--
  Created by IntelliJ IDEA.
  User: MisakaE
  Date: 2022/12/26
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>MisakaE</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/custom-css.css">
    <script src="js/jquery.min.js"></script>

    <link rel="stylesheet" href="css/list.css">
    <script src="js/snowy.js"></script>
</head>
<body>

<style>.snow-container{position:fixed;top:0;left:0;width:100%;height:100%;pointer-events:none;z-index:100001;}</style>
<div class="snow-container"></div>
<!--导航栏-->
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary rounded" style="opacity: 0.9">
        <a class="navbar-brand" href="#">MisakaE's Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample09">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">分类</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">友链</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li><a class="nav-link " href="blog_login.jsp" id="login"></a></li>
            </ul>
        </div>
    </nav>
</div>

    <div id="BlogList" style="opacity: 0.8"></div>
    <script>
        let tuid;
        $.getJSON("login",function (user){tuid=user.uid})
        $.getJSON("blog",function (list){
            let cent = document.getElementById("BlogList");
            let str='';
            for(let i=0;i < list.length;i ++){
                str +="<br>"+
                    "<div class=\"card m-auto\" style=\"width:60rem\" > <div class=\"card-body\" > <h5 class=\"card-title\">"+list[i].title+"</h5> <h6 class=\"card-subtitle mb-2 text-muted\">"
                +""+"</h6>"
                    +
                "<p class=\"card-text\">"+list[i].body+"</p>";


                if(tuid==1)str+="<a href=\'blogdelete?bid="+list[i].bid+"\' class=\'card-link\'>删除" + "</a>";



                str += "<a href=\'blog_detail.jsp?bid=" + list[i].bid +"\' class=\"card-link\">点击进入</a> " +
                    "</div> </div>"+"<br>";


            }
            cent.innerHTML = str
        })
    </script>
    <script>
        $.getJSON('login',function (user){
            let fig = document.getElementById("login");
            let str;
            if(user.uid==-1)str = "登录/注册";
            else str = user.username;
            fig.innerHTML = str;
        })
    </script>
</body>
</html>
