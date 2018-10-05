<%--
  Created by IntelliJ IDEA.
  User: justy
  Date: 2018/10/5
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="msgFrompPush"></div>

<script src="/assets/js/jQuery3.3.1.js"/>
<script>
    if (!!window.EventSource) {
        var source = new EventSource('push');
        s = '';
        source.addEventListener('message', function (evt) {
            s += e.data + "</br>";
            $("#msgFrompPush").html(s);
        });
        source.addEventListener('open', function (evt) {
            console.log('链接打开');
        }, false);
        source.addEventListener('error', function (evt) {
            if (e.readyState == EventSource.CLOSED) {
                console.log('连接关闭')
            }
        }, false);
    } else {
        console.log('浏览器不支持sse')
    }
</script>
</body>
</html>
