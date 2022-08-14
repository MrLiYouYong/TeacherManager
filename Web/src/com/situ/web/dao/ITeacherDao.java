package com.situ.web.dao;

import com.situ.web.pojo.Teacher;
import com.situ.web.pojo.User;

import java.util.List;

public interface ITeacherDao {
    List<Teacher> selectPage(Integer offset, Integer limit);

    Integer selectTotalCount();

    void deleteById(int id);

    void add(Teacher teacher);

    Teacher selectById(int id);

    void update(Teacher teacher);
}
