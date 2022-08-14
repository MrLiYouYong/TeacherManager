package com.lyy.emp.controller;

import com.lyy.emp.entity.EmpManager;
import com.lyy.emp.service.EmpManagerService;
import com.lyy.emp.service.impl.EmpManagerServiceImpl;
import com.lyy.emp.utils.JSONResult;
import com.lyy.emp.utils.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmpManagerLoginController", value = "/manager/EmpManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("code");

        //校验验证码
        String code = (String) request.getSession().getAttribute("code");

        if (!code.equalsIgnoreCase(inputVcode)) {
            JSONUtil.toJSON(response, JSONResult.error("验证码错误"));
            return;
        }
            //业务逻辑

            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username,password);
            if (empManager == null) {
                JSONUtil.toJSON(response, JSONResult.error("用户名或密码错误"));
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("empManager", empManager);
                JSONUtil.toJSON(response, JSONResult.ok("登录成功"));
        }

            if(empManager!=null){
                //登录成功
                //储存在session作用域
                HttpSession session = request.getSession();
                session.setAttribute("empManager",empManager);

                response.sendRedirect(request.getContextPath()+"/manager/safe/ShowAllEmpController");

            }else{
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
    }
}
