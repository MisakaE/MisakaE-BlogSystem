<%--
  Created by IntelliJ IDEA.
  User: MisakaE
  Date: 2022/12/26
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>MisakaE</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="editor.md/css/editormd.min.css" />
    <script src="editor.md/lib/marked.min.js"></script>
    <script src="editor.md/lib/prettify.min.js"></script>
    <script src="editor.md/editormd.js"></script>
    <link rel="stylesheet" href="editor.md/css/editormd.min.css" />
    <link rel="stylesheet" href="css/detil.css">
    <script src="js/jquery.min.js"></script>
</head>
<body>
<header>
<br>
    <div class="blog-header">
        <div class="container">
            <br>
            <h1 class="blog-title" id="title">The</h1>
            <p class="lead blog-description"></p>
        </div>
    </div>
</header>
<main role="main" class="container">
    <div class="row" style="opacity: 0.7">
        <div class="col-sm-12 blog-main">
            <div class="blog-post" id="content">
            </div>
        </div>
    </div>
    <script>
        let url = "blog"+location.search;
        $.getJSON(url,function (detail){

            let str=detail.body;
            editormd.markdownToHTML('content',{
                tex : true,
                //dialogMaskOpacity : 0.1,
                //dialogMaskBgColor : "#000",
                markdown : str,

            });
            let tit = document.getElementById("title");
            tit.innerHTML = detail.title

        })
    </script>
</main>
</body>
</html>
