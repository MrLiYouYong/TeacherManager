package com.situ.web.dao.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.pojo.Teacher;
import com.situ.web.pojo.User;
import com.situ.web.util.DbUtils;
import com.situ.web.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeacherDaoImpl implements ITeacherDao {
    QueryRunner queryRunner = new QueryRunner();
    public List<Teacher> selectPage(Integer offset, Integer limit) {
        List<Teacher> list = null;
        try {
            list = queryRunner.query(DbUtils.getConnection(),"select * from teacher limit ?,?;",new BeanListHandler<Teacher>(Teacher.class),offset,limit);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Long selectTotalCount() {
        long result = 0;
        try {
            result = queryRunner.query(DbUtils.getConnection(),"select count(*) from teacher",new ScalarHandler<>());
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteById(int id) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection(),"delete from teacher where id=?",id);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int add(Teacher teacher) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection(),"insert into teacher(name,age,object,salary,address) values(?,?,?,?,?)"
                    ,teacher.getName(),teacher.getAge(),teacher.getObject(),teacher.getSalary(),teacher.getAddress());
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Teacher selectById(int id) {
        try {
            Teacher teacher = queryRunner.query(DbUtils.getConnection(),"select * from teacher where id=?",new BeanHandler<Teacher>(Teacher.class),id);
            return teacher;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Teacher teacher) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection(),"update teacher set name=?,age=?,object=?,salary=?,address=? where id=?"
                    ,teacher.getName(),teacher.getAge(),teacher.getObject(),teacher.getSalary(),teacher.getAddress());
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
