
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user?method=login" method="post">
    用户名:<input type="text" name="name"/> <br/>
    密码: <input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
