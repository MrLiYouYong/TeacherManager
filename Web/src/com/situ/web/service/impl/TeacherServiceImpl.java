package com.situ.web.service.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.dao.impl.TeacherDaoImpl;
import com.situ.web.pojo.Teacher;
import com.situ.web.pojo.User;
import com.situ.web.service.ITeacherService;
import com.situ.web.util.JSONResult;
import com.situ.web.util.LayUITableJSONResult;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        List<Teacher> list = teacherDao.selectPage(offset, limit);
        Integer totalCount = teacherDao.selectTotalCount();

        return LayUITableJSONResult.ok(totalCount, list);
    }

    @Override
    public JSONResult deleteById(int id) {
        teacherDao.deleteById(id);
        return JSONResult.ok("删除成功");
    }

    @Override
    public JSONResult deleteAll(String[] ids) {
        for (String id : ids) {
            teacherDao.deleteById(Integer.parseInt(id));
        }
        return JSONResult.ok("删除成功");
    }

    @Override
    public JSONResult add(Teacher teacher) {
        teacherDao.add(teacher);
        return JSONResult.ok("添加成功");
    }

    @Override
    public Teacher selectById(int id) {
        Teacher teacher = teacherDao.selectById(id);
        return teacher;
    }

    @Override
    public JSONResult update(Teacher teacher) {
        teacherDao.update(teacher);
        return JSONResult.ok("修改成功");
    }
}
