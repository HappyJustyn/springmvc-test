<%--
  Created by IntelliJ IDEA.
  User: justy
  Date: 2018/10/6
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="/assets/js/jQuery3.3.1.js"></script>
    <script>
        deferred();
        function deferred() {
            $.get('defer', function (data) {
                console.log(data);
                deferred();
            });
        }
    </script>
</body>
</html>
