package com.situ.web.controller;

import com.situ.web.pojo.Teacher;
import com.situ.web.service.ITeacherService;
import com.situ.web.service.impl.TeacherServiceImpl;
import com.situ.web.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    private ITeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "update":
                update(req,resp);
                break;
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "deleteAll":
                deleteAll(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "getUserUpdatePage":
                getUserUpdatePage(req, resp);
                break;
            default:
                break;
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("TeacherServlet.update");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String object = req.getParameter("object");
        String salary = req.getParameter("salary");
        String address = req.getParameter("address");


        Teacher teacher = new Teacher(Integer.parseInt(id),name,Integer.parseInt(age),object,Integer.parseInt(salary),address);
        JSONResult jsonResult = teacherService.update(teacher);
        JSONUtil.toJSON(resp,jsonResult);
    }

    private void getUserUpdatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherServlet.getUserUpdatePage");
        String id = req.getParameter("id");
        Teacher teacher = teacherService.selectById(Integer.parseInt(id));
        req.setAttribute("teacher", teacher);
//        System.out.println(req.getSession().getAttribute("user"));
        req.getRequestDispatcher("teacher_update.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("TeacherServlet.add");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String object  =req.getParameter("object");
        String salary = req.getParameter("salary");
        String address = req.getParameter("address");
        Teacher teacher = new Teacher(name,Integer.parseInt(age),object,Integer.parseInt(salary),address);
        JSONResult jsonResult = teacherService.add(teacher);
        JSONUtil.toJSON(resp, jsonResult);
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("UserServlet.deleteAll");
        String[] ids = req.getParameterValues("ids[]");
        System.out.println(Arrays.toString(ids));
        JSONResult jsonResult = teacherService.deleteAll(ids);

        JSONUtil.toJSON(resp, jsonResult);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("TeacherServlet.deleteById");
        String id = req.getParameter("id");
        JSONResult jsonResult = teacherService.deleteById(Integer.parseInt(id));
        JSONUtil.toJSON(resp, jsonResult);
    }



    // http://localhost:8080/JavaWeb/teacher?method=selectByPage&pageNo=2&pageSize=5
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("TeacherServlet.selectByPage");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");

        LayUITableJSONResult layUITableJSONResult = teacherService.selectByPage(Integer.parseInt(page), Integer.parseInt(limit));

        JSONUtil.toJSON(resp, layUITableJSONResult);
    }



}
