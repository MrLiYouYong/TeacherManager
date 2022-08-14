package com.lyy.web.servlet;

import com.lyy.web.entity.Teacher;
import com.lyy.web.util.JDBCUtil;
import com.lyy.web.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectByPage":
                selectByPage(req, resp);
                break;
            default:
                break;
        }
    }


    // http://localhost:8080/JavaWeb/teacher?method=selectByPage&pageNo=2&pageSize=5
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherServlet.selectByPage");
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        if (pageNo == null || pageNo.equals("")) {
            pageNo = "1";
        }
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "5";
        }
        int pageN = Integer.parseInt(pageNo);
        int pageS = Integer.parseInt(pageSize);
        // 封装PageInfo
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNo(pageN);
        pageInfo.setPageSize(pageS);
        // 分页涉及两条sql语句
        // 1、查询当前页的数据
        int offset = (pageN - 1) * pageS;
        List<Teacher> list = selectPage(offset, pageS);
        pageInfo.setList(list);
        // 2、查询总的数量
        int totalCount = selectTotalCount();
        // int totalPage = totalCount / pageSize;
        int totalPage = (int)Math.ceil((double)totalCount / pageS);
        pageInfo.setTotalPage(totalPage);

        System.out.println(pageInfo);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("teacher_list.jsp").forward(req, resp);
    }

    private int selectTotalCount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select count(*) from teacher";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }

        return count;
    }

    private List<Teacher> selectPage(int offset, int pageSize) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Teacher> list = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,age,address from teacher limit ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                Teacher teacher = new Teacher(id, name, age,address);
                list.add(teacher);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }

        return list;
    }


}
