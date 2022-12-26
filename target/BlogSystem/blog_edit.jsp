<%--
  Created by IntelliJ IDEA.
  User: MisakaE
  Date: 2022/12/26
  Time: 9:55
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
    <!-- 登陆验证 -->
    <script>
        $.getJSON('login',function (user){
            if(user.uid == -1){
                alert("请先登录");
                location.assign('blog_list.jsp');
            }
            else{
                let butt = document.getElementById("sub");
                butt.innerHTML = "<input type=\"submit\" value=\"发布文章\" id=\"submit\">"
            }
        })
    </script>
    <!-- 博客编辑器 -->
    <form method="post" action="blog" style="height: 100%">
        <input type="text" placeholder="输入标题" name="title" id="title">
        <span id="sub"></span>
        <div id="editor">
            <textarea name="body" style="display:none"></textarea>
        </div>
    </form>
    <script type="text/javascript">
        $(function() {
            var editor = editormd("editor", {
                width: "100%",
                height: "100%",
                //markdown: "To Begin",     // dynamic set Markdown text
                path : "editor.md/lib/"  // Autoload modules mode, codemirror, marked... dependents libs path
            });
        });
    </script>

</body>
</html>
