package com.situ.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.vo.SalaryCount;
import com.situ.web.util.DbUtils;

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

@WebServlet("/echarts")
public class TeacherEchartsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SalaryCount> list = new ArrayList<>();
        try {
            connection = DbUtils.getConnection();
            String sql = "SELECT salary ,COUNT(*) AS value FROM teacher GROUP BY salary";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int salary = resultSet.getInt("salary");
                int value = resultSet.getInt("value");
                SalaryCount salaryCount = new SalaryCount(salary,value);
                list.add(salaryCount);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), list);
    }
}
