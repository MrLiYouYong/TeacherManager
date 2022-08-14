package com.situ.web.service;

import com.situ.web.pojo.Teacher;
import com.situ.web.pojo.User;
import com.situ.web.util.JSONResult;
import com.situ.web.util.LayUITableJSONResult;

public interface ITeacherService {
    LayUITableJSONResult selectByPage(Integer page, Integer limit);

    JSONResult deleteById(int id);

    JSONResult deleteAll(String[] ids);

    JSONResult add(Teacher teacher);

    Teacher selectById(int id);

    JSONResult update(Teacher teacher);
}
