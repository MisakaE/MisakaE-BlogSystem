<%@ page import="static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title" %><%--
  Created by IntelliJ IDEA.
  User: MisakaE
  Date: 2022/12/26
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MisakaE</title>
    <script src="js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/underscore@1.13.6/underscore-umd-min.js"></script>
</head>
<body>
    <div id="BlogList"></div>
    <script>
        $.getJSON("blog",function (list){
            let cent = document.getElementById("BlogList");
            let str='';
            for(let i=0;i < list.length;i ++){
                str += "<p>" +
                    list[i].title + "<br>" + list[i].body + "<br>"+"<a href='blog_detail.jsp?bid="+list[i].bid+"'>"+"点此进入</a>"+i+"</p>";
            }
            cent.innerHTML = str
        })
    </script>
</body>
</html>
