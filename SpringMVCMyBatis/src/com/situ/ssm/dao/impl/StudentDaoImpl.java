package com.situ.ssm.dao.impl;

import com.situ.ssm.dao.IStudentDao;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    private SqlSession sqlSession;

    public StudentDaoImpl() {
        sqlSession = MyBatisUtil.getSqlSession();
    }

    @Override
    public List<Student> selectAll() {
        List<Student> list =  sqlSession.selectList("student.selectAll");
        return list;
    }
}
