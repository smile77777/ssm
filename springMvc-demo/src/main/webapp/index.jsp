
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/demo.action">访问服务器</a><br/><br>
<form action="${pageContext.request.contextPath}/one.action" method="post">
    名字:<input name="name"><br>
    年龄:<input name="age"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
