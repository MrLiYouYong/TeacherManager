package com.situ.web.service.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.dao.impl.TeacherDaoImpl;
import com.situ.web.pojo.Teacher;
import com.situ.web.pojo.User;
import com.situ.web.service.ITeacherService;
import com.situ.web.util.DbUtils;
import com.situ.web.util.JSONResult;
import com.situ.web.util.LayUITableJSONResult;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {
        int offset = 0;
        List<Teacher> list = null;
        long totalCount = 0;
        try {
            DbUtils.begin();
            offset = (page - 1) * limit;
            list = teacherDao.selectPage(offset, limit);
            totalCount = teacherDao.selectTotalCount();
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return LayUITableJSONResult.ok((int)totalCount,list);
    }

    @Override
    public JSONResult deleteById(int id) {
        int result = 0;
        String str = "";

        try {
            DbUtils.begin();
            result = teacherDao.deleteById(id);
            if (result != 0) {
                str = "删除成功！";
            } else {
                str = "删除失败！";
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return JSONResult.ok(str);
    }

    @Override
    public JSONResult deleteAll(String[] ids) {
        int result = 0;
        String str = "";
        try {
            DbUtils.begin();

            for (String id : ids) {
                result = teacherDao.deleteById(Integer.parseInt(id));
                if(result != 0){
                    str = "删除成功！";
                } else {
                    str = "删除失败！";
                }
            }
            DbUtils.commit();

        } catch (NumberFormatException e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return JSONResult.ok(str);
    }

    @Override
    public JSONResult add(Teacher teacher) {
        int result = 0;
        String str = "";

        try {
            DbUtils.begin();
            result = teacherDao.add(teacher);
            if ( result != 0) {
                str = "添加成功！";
            } else {
                str = "添加失败！";
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return JSONResult.ok(str);
    }

    @Override
    public Teacher selectById(int id) {
        Teacher teacher = null;

        try {
            DbUtils.begin();
            Teacher temp = teacherDao.selectById(id);
            if(temp != null){
                teacher = temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public JSONResult update(Teacher teacher) {
        String str = "";
        int result = 0;
        try {
            DbUtils.begin();
            result =  teacherDao.update(teacher);
            if(result != 0){
                str = "修改成功！";
            } else {
                str = "修改失败！";
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return JSONResult.ok(str);
    }
}
