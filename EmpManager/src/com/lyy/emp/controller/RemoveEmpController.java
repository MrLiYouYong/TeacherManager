package com.lyy.emp.controller;

import com.lyy.emp.service.EmpService;
import com.lyy.emp.service.impl.EmpServiceImpl;
import com.lyy.emp.utils.JSONResult;
import com.lyy.emp.utils.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveEmpController", value = "/manager/safe/RemoveEmpController")
public class RemoveEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        EmpService empService = new EmpServiceImpl();
        empService.removeEmp(id);

        JSONUtil.toJSON(response, JSONResult.ok("删除成功"));

//        response.sendRedirect(request.getContextPath()+"/manager/safe/ShowAllEmpController");
    }
}
