<%--
  Created by IntelliJ IDEA.
  User: hello_lyy
  Date: 2022/7/21
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/student" method="get">
        用户名:<input type="text" name="name"/><br/>
        年龄：<input type="text" name="age"/><br/>
        性别：<input type="text" name="gender"/><br/>
        <input type="text" name="method" value="add"/><br/>
        <input type="submit" value="添加"/>
    </form>
</body>
</html>
