package com.situ.web.dao;

import com.situ.web.pojo.Teacher;

import java.util.List;

public interface ITeacherDao {
    List<Teacher> selectPage(Integer offset, Integer limit);

    Integer selectTotalCount();

    int deleteById(int id);

    int add(Teacher teacher);

    Teacher selectById(int id);

    int update(Teacher teacher);
}
