package com.situ.web.dao.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.pojo.Teacher;
import com.situ.web.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements ITeacherDao {

    public List<Teacher> selectPage(Integer offset, Integer limit) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Teacher> list = new ArrayList<>();
        try {
            connection = DbUtils.getConnection();
            String sql = "select id,name,age,object,salary,address from teacher limit ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String object = resultSet.getString("object");
                int salary = resultSet.getInt("salary");
                String address = resultSet.getString("address");
                Teacher teacher = new Teacher(id,name,age,object,salary,address);
                list.add(teacher);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeAll(connection, statement, resultSet);
        }

        return list;
    }

    @Override
    public Integer selectTotalCount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DbUtils.getConnection();
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
            DbUtils.closeAll(connection, statement, resultSet);
        }

        return count;
    }

    @Override
    public int deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "delete from teacher where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeAll(connection, statement, null);
        }
        return id;
    }

    @Override
    public int add(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "insert into teacher(name,age,object,salary,address) values(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getName());
            statement.setInt(2, teacher.getAge());
            statement.setString(3,teacher.getObject());
            statement.setInt(4,teacher.getSalary());
            statement.setString(5, teacher.getAddress());
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeAll(connection, statement, null);
        }
        return 0;
    }

    @Override
    public Teacher selectById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Teacher teacher = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "select id,name,age,object,salary,address from teacher where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String object = resultSet.getString("object");
                int salary = resultSet.getInt("salary");
                String address = resultSet.getString("address");
                teacher = new Teacher(id, name, age,object,salary,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeAll(connection, statement, resultSet);
        }

        return teacher;
    }

    @Override
    public int update(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "update teacher set name=?,age=?,object=?,salary=?,address=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,teacher.getName());
            statement.setInt(2,teacher.getAge());
            statement.setString(3,teacher.getObject());
            statement.setInt(4, teacher.getSalary());
            statement.setString(5,teacher.getAddress());
            statement.setInt(6,teacher.getId());
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeAll(connection, statement, null);
        }
        return 0;
    }
}
