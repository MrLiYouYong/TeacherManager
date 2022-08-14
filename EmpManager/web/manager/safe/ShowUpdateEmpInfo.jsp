<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.lyy.emp.entity.Emp" %><%--
  Created by IntelliJ IDEA.
  User: hello_lyy
  Date: 2022/7/9
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息页面</title>
</head>
<body>
    <form class=" .form-horizontal" action="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/UpdateEmpController'></c:url>" method="post">
        编号：<input type="text" name='id' value="${emp.id}" readonly/><br/>
        姓名：<input type='text' name='name' value="${emp.name}"/><br/>
        工资：<input type='text' name='salary' value="${emp.salary}"/><br/>
        年龄：<input type='text' name='age' value="${emp.age}"/><br/>
        <input type='submit'  value='修改'/><br/>
</form>
</body>
</html>
