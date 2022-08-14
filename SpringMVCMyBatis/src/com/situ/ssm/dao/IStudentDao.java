package com.situ.ssm.dao;

import com.situ.ssm.pojo.Student;

import java.util.List;


public interface IStudentDao {
    List<Student> selectAll();
}
