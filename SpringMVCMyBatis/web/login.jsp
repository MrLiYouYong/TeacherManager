<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- 引入css文件 -->
        <link rel="stylesheet" href="./login.css">
        <!-- 引入jquery -->
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <title>登录</title>
    </head>
    <body>
        <!-- 最外层的大盒子 -->
       <div class="box">
        <!-- 滑动盒子 -->
        <div class="pre-box">
            <h1>WELCOME</h1>
            <p>JOIN US!</p>
            <div class="img-box">
                <img src="./img/waoku.jpg" alt="">
            </div>
        </div>
        <!-- 注册盒子 -->
        <div class="register-form">
            <!-- 标题盒子 -->
            <div class="title-box">
                <h1>注册</h1>
            </div>
            <!-- 输入框盒子 -->

            <div class="input-box">
                <input type="text" placeholder="用户名">
                <input type="password" placeholder="密码">
                <input type="password" placeholder="确认密码">
            </div>

            <!-- 按钮盒子 -->
            <div class="btn-box">
                <button>注册</button>
                <!-- 绑定点击事件 -->
                <p onclick="mySwitch()">已有账号?去登录</p>
            </div>
        </div>
        <!-- 登录盒子 -->
        <div class="login-form">
            <!-- 标题盒子 -->
            <div class="title-box">
                <h1>登录</h1>
            </div>
            <!-- 输入框盒子 -->
            <div class="input-box">
                <input type="text" placeholder="用户名" name="username" id="nameId">
                <input type="password" placeholder="密码" name="password" id="passwordId">
                <input type="text" placeholder="验证码" name="inputVcode" id="codeId" onclick="refresh()"/>
                <img src="/SpringMVCMyBatis/CreateCodeController"><br/>
            </div>
            <!-- 按钮盒子 -->
            <div class="btn-box">
                <button onclick="submitForm()">登录</button>
                <!-- 绑定点击事件 -->
                <p onclick="mySwitch()">没有账号?去注册</p>
            </div>
        </div>
       </div>


        <script src="<%=request.getContextPath()%>/static/jquery-2.1.4.js"></script>
        <script src="<%=request.getContextPath()%>/static/layer/layer.js"></script>
        <script src="<%=request.getContextPath()%>/static/mylayer.js"></script>

        <script>
            function refresh() {
                $('#codeId').attr('src', "/SpringMVCMyBatis/CreateCodeController");
            }
        </script>

        <script>

            function submitForm() {
                var nameId = $('#nameId').val();
                var passwordId = $('#passwordId').val();
                var codeId = $('#codeId').val();
                $.get(

                    '${pageContext.request.contextPath}/manager/EmpManagerLoginController',
                    {"username":nameId,"password":passwordId,"code":codeId},
                    function(jsonResult) {
                        console.log(jsonResult);
                        if (jsonResult.code == 0) {
                            mylayer.okUrl(jsonResult.msg, '${pageContext.request.contextPath}/index.jsp');
                            <%--mylayer.okUrl(jsonResult.msg, '${pageContext.request.contextPath}/manager/safe/ShowAllEmpController');--%>
                        } else {
                            mylayer.errorMsg(jsonResult.msg);
                            <%-- mylayer.errorUrl(jsonResult.msg,'${pageContext.request.contextPath}/login.jsp');--%>
                        }
                    },
                    'json'
                );
            }
        </script>

       <script>
            // 滑动的状态
             let flag=true
             const mySwitch=()=>{
                if(flag){
                    // 获取到滑动盒子的dom元素并修改它移动的位置
                    $(".pre-box").css("transform","translateX(100%)")
                    // 获取到滑动盒子的dom元素并修改它的背景颜色
                    $(".pre-box").css("background-color","#c9e0ed")
                    //修改图片的路径
                    $("img").attr("src","./img/wuwu.jpeg")
                    
                }
                else {
                    $(".pre-box").css("transform","translateX(0%)")
                    $(".pre-box").css("background-color","#edd4dc")
                    $("img").attr("src","./img/waoku.jpg")
                }
                flag=!flag
             }
       </script>
       <script>
            const bubleCreate=()=>{
                // 获取body元素
                const body = document.body
                // 创建泡泡元素
                const buble = document.createElement('span')
                // 设置泡泡半径
                let r = Math.random()*5 + 25 //半径大小为25~30
                // 设置泡泡的宽高
                buble.style.width=r+'px'
                buble.style.height=r+'px'
                // 设置泡泡的随机起点
                buble.style.left=Math.random()*innerWidth+'px'
                // 为body添加buble元素
                body.append(buble)
                // 4s清除一次泡泡
                setTimeout(()=>{
                    buble.remove()
                },4000)
            }
            // 每200ms生成一个泡泡
            setInterval(() => {
                bubleCreate()
            }, 200);
        </script>
    </body>
</html>