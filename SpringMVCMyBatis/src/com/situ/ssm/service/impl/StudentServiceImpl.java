package com.situ.ssm.service.impl;

import com.situ.ssm.dao.IStudentDao;
import com.situ.ssm.dao.impl.StudentDaoImpl;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }
}
