package com.lyy.emp.controller;

import com.lyy.emp.entity.Emp;
import com.lyy.emp.entity.Page;
import com.lyy.emp.service.EmpService;
import com.lyy.emp.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllEmpController", value = "/manager/safe/ShowAllEmpController")
public class ShowAllEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String pageIndex = request.getParameter("pageIndex");

        if(pageIndex==null){
            pageIndex = "1";
        }

        Page page = new Page(Integer.valueOf(pageIndex));

        EmpService empService = new EmpServiceImpl();
        List<Emp> emps = empService.showAllEmp(page);


        request.setAttribute("emps",emps);
        request.setAttribute("page",page);

        request.getRequestDispatcher("/manager/safe/ShowAllEmp.jsp").forward(request,response);

    }
}
