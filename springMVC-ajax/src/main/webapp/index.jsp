<%--
  Created by IntelliJ IDEA.
  User: 时亚丽
  Date: 2022-11-01
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<br><br>
<a href="javascript:showStu()">返回服务器学生集合</a>
<div id="mydiv">等待服务器返回数据</div>
<script type="text/javascript">
    function showStu(){
        $.ajax({
            url:"${pageContext.request.contextPath}/list.action",
            type:"get",
            dataType:"json",
            success:function (stuList){
                var s="";
                $.each(stuList,function (i,stu){
                    s+=stu.name+"-----"+stu.age+"<br>";
                });
                $("#mydiv").html(s);
            }
        });
    }
</script>
</body>
</html>
