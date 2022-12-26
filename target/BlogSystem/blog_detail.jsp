<%--
  Created by IntelliJ IDEA.
  User: MisakaE
  Date: 2022/12/26
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MisakaE</title>
    <link rel="stylesheet" href="editor.md/css/editormd.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="editor.md/lib/marked.min.js"></script>
    <script src="editor.md/lib/prettify.min.js"></script>
    <script src="editor.md/editormd.js"></script>
    <link rel="stylesheet" href="editor.md/css/editormd.min.css" />
</head>
<body>
    <div id="title"></div>
    <div id="content" style="opacity: 80%"></div>

    <script>
        let url = "blog"+location.search;
        let tit = document.getElementById("title");
        $.getJSON(url,function (detail){

            let str=detail.body;
            editormd.markdownToHTML("content",{markdown : str});
            tit.innerHTML = "<h2> "+detail.title + "</h2>"

        })
    </script>
</body>
</html>
