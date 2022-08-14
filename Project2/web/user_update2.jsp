<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 2022/7/25
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/layui/css/layui.css"  media="all">
</head>
<body>
    <form id="formId" class="layui-form layui-form-pane" action="">
        <input type="hidden" name="id" id="id"/>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="name" id="nameId"  autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" id="passwordId" autocomplete="off" placeholder="请输入密码" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age" id="ageId" autocomplete="off" placeholder="请输入年龄" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" id="addressId" autocomplete="off" placeholder="请输入地址" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                    <input type="radio" name="gender" value="男" title="男">
                    <input type="radio" name="gender" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" onclick="submitForm()" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <script src="<%=request.getContextPath()%>/static/jquery-2.1.4.js"></script>
    <script src="<%=request.getContextPath()%>/static/layui/layui.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/static/layer/layer.js"></script>
    <script src="<%=request.getContextPath()%>/static/mylayer.js"></script>
    <script>
        $(function() {
            $.post(
                '${pageContext.request.contextPath}/user?method=selectById',
                {id : '${param.id}'},
                function(jsonResult) {
                    console.log(jsonResult);
                    // {id: 27, name: 'wangwu', password: '123', age: 12, address: 'qingdao', …}
                    var user = jsonResult.data;
                    $('#id').val(user.id);
                    $('#nameId').val(user.name);
                    $('#passwordId').val(user.password);
                    $('#ageId').val(user.age);
                    $('#addressId').val(user.address);
                    // $('input[name="gender"]')
                },
                'json'
            );
        });

        layui.use(['form', 'laydate'], function() {
            var form = layui.form;
            var laydate = layui.laydate;
        });

        function submitForm() {
            $.post(
                '${pageContext.request.contextPath}/user?method=update',
                $('#formId').serialize(),
                function(jsonResult) {
                    console.log(jsonResult);
                    if (jsonResult.code == 0) {
                        // mylayer.okMsg(jsonResult.msg);
                        // 获得当前弹出框的index
                        var index = parent.layer.getFrameIndex(window.name);
                        layer.msg(
                            jsonResult.msg,
                            {icon:1, time:1000},
                            function() { // msg弹出1秒后消失触发这个函数
                                // 关闭弹出层
                                parent.layer.close(index);
                                // 刷新父页面
                                window.parent.location.reload();
                            }
                        );
                    } else {
                        mylayer.errorMsg(jsonResult.msg);
                    }
                },
                'json'
            );
        }
    </script>
</body>
</html>
