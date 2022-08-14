<%@ page import="com.lyy.emp.entity.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hello_lyy
  Date: 2022/7/9
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有员工信息</title>
    <link rel="stylesheet" type="text/css" href="static/bootstrap-3.4.1-dist/css/bootstrap.css"/>
</head>
<body>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>工资</td>
        <td>年龄</td>
        <td colspan="2">操作</td>
    </tr>
    <c:forEach var="emp" items="${emps}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.salary}</td>
            <td>${emp.age}</td>
            <td><a href="javascript:deleteById(${emp.id})">删除</a></td>
<%--            <td><a href="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/RemoveEmpController?id=${emp.id}'></c:url>">删除</a></td>--%>
            <td><a href="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/ShowEmpController?id=${emp.id}'></c:url>">修改</a></td>
        </tr>
    </c:forEach>


    <tr>
        <td colspan="6">
            <a href="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/ShowAllEmpController?pageIndex=1'/>" >首页</a>

            <c:if test="${page.pageIndex > 1}">
                <a href="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/ShowAllEmpController?pageIndex=${page.pageIndex-1}'/>" >上一页</a>
            </c:if>
            <c:if test="${page.pageIndex==1}"><a>上一页</a></c:if>



            <c:if test="${page.pageIndex < page.totalPages}">
                <a href="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/ShowAllEmpController?pageIndex=${page.pageIndex+1}'/>" >下一页</a>
            </c:if>
            <c:if test="${page.pageIndex == page.totalPages}"><a>下一页</a></c:if>

            <a href="<c:url context='${pageContext.request.contextPath}' value='/manager/safe/ShowAllEmpController?pageIndex=${page.totalPages}'/>" >尾页</a>
        </td>
    </tr>

    <script src="<%=request.getContextPath()%>/static/jquery-2.1.4.js"></script>
    <script src="<%=request.getContextPath()%>/static/layer/layer.js"></script>
    <script src="<%=request.getContextPath()%>/static/mylayer.js"></script>

    <script>
        function deleteById(id) {
            layer.confirm('您确定要删除么？', function() {
                $.post(
                    '${pageContext.request.contextPath}/manager/safe/RemoveEmpController',
                    {'id' : id},
                    function(jsonObj) {
                        // {msg: '删除成功', code: 0}
                        console.log(jsonObj);
                        if (jsonObj.code == 0) {
                            mylayer.okUrl(jsonObj.msg, '${pageContext.request.contextPath}/manager/safe/ShowAllEmpController');

                        } else {
                            mylayer.errorMsg(jsonObj.msg);
                        }
                    },
                    'json'
                );
            })


        }
    </script>

</table>
</body>
</html>
