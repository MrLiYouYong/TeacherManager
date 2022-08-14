package com.lyy.emp.jsp;

import com.lyy.emp.entity.Emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllEmpJSP", value = "/manager/safe/ShowAllEmpJSP")
public class ShowAllEmpJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Emp> emps = (List<Emp>) request.getAttribute("emps");

        PrintWriter printWriter = response.getWriter();


        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查询所有员工页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <table border='1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>编号</td>");
        printWriter.println("               <td>姓名</td>");
        printWriter.println("               <td>工资</td>");
        printWriter.println("               <td>年龄</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(Emp emp: emps){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+emp.getId()+"</td>");
            printWriter.println("               <td>"+emp.getName()+"</td>");
            printWriter.println("               <td>"+emp.getSalary()+"</td>");
            printWriter.println("               <td>"+emp.getAge()+"</td>");
            printWriter.println("               <td><a href='"+request.getContextPath()+"/manager/safe/RemoveEmpController?id="+emp.getId()+"'>删除<a></td>");
            printWriter.println("               <td><a href='"+request.getContextPath()+"/manager/safe/ShowEmpController?id="+emp.getId()+"'>修改</a></td>");
            printWriter.println("           </tr>");
        }
        printWriter.println("       </table>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }
}
