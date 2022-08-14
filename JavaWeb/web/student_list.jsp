<%@ page import="java.util.List" %>
<%@ page import="com.lyy.web.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 2022/7/20
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/bootstrap-3.4.1-dist/css/bootstrap.css"/>
</head>
<body>
<%--${list}--%>
<%
    // jsp脚本，可以任意写java代码
    // request内置对象
    List<Student> list = (List<Student>) request.getAttribute("list");

%>
<a href="<%=request.getContextPath()%>/student_add.jsp">添加</a>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>ID</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        for (Student student : list) {

    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getGender()%></td>
        <td><a href="javascript:deleteById(<%=student.getId()%>)">删除</a></td>
        <%--td><a href="<%=request.getContextPath()%>/student_update.jsp">编辑</a></td>--%>
        <td><a href="<%=request.getContextPath()%>/student?method=getStudentUpdatePage&id=<%=student.getId()%>">编辑</a></td>
    </tr>
    <%
        }
    %>
</table>

<script>
    function deleteById(id) {
        var isDelete = confirm('您确认要删除么？');
        if (isDelete) {
            location.href = '<%=request.getContextPath()%>/student?method=deleteById&id=' + id;
        }
    }
</script>
</body>
</html>