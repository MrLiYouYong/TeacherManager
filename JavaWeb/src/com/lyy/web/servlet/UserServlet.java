package com.lyy.web.servlet;

import com.lyy.web.entity.User;
import com.lyy.web.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        /*if (method == null || method.equals("")) {
            method = "selectByPage";
        }*/
        switch (method) {
            case "login":
                login(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
            default:
                break;
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        // session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,password from users where name=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String password1 = resultSet.getString("password");
                user = new User(id, name1, password1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (user == null) {// 用户名密码错误
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
        } else {// 登录成功

            HttpSession session = req.getSession();
            session.setAttribute("name"+user.getName(),user.getName());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            System.out.println(session.getAttribute("name"+user.getName()));
            System.out.println(session.getAttribute("namezhangsan"));
            System.out.println(session.getId());
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath());
        }

    }
}
//zhangsan
//899B14BAE393CAFF55B3598608D5F55A
//lisi
//899B14BAE393CAFF55B3598608D5F55A
