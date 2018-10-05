<%--
  Created by IntelliJ IDEA.
  User: justy
  Date: 2018/10/5
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <button type="submit">提交</button>
    </form>
</body>
</html>
