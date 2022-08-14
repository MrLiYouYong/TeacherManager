package com.lyy.emp.controller;

import com.lyy.emp.entity.Emp;
import com.lyy.emp.service.EmpService;
import com.lyy.emp.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowEmpController", value = "/manager/safe/ShowEmpController")
public class ShowEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        EmpService empService = new EmpServiceImpl();

        Emp emp = empService.showEmp(id);

        request.setAttribute("emp",emp);
        System.out.println(emp);
        request.getRequestDispatcher("/manager/safe/ShowUpdateEmpInfo.jsp").forward(request,response);

    }
}
