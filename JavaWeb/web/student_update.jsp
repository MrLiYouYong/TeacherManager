<%@ page import="com.lyy.web.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 2022/7/21
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
%>
<form action="<%=request.getContextPath()%>/student?method=update" method="post">
    <input type="hidden" name="id" value="<%=student.getId()%>"/>
    用户名:<input type="text" name="name" value="<%=student.getName()%>"/><br/>
    年龄：<input type="text" name="age" value="<%=student.getAge()%>"/><br/>
    性别：<input type="text" name="gender" value="<%=student.getGender()%>"/><br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
