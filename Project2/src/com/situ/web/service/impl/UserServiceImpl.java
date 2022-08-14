package com.situ.web.service.impl;

import com.situ.web.dao.IUserDao;
import com.situ.web.dao.impl.UserDaoImpl;
import com.situ.web.pojo.User;
import com.situ.web.service.IUserService;
import com.situ.web.util.DbUtils;
import com.situ.web.util.JSONResult;
import com.situ.web.util.LayUITableJSONResult;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {

        int offset = 0;
        List<User> list = null;
        long totalCount = 0;
        try {
            DbUtils.begin();
            offset = (page - 1) * limit;
            list = userDao.selectPage(offset, limit);
            totalCount = userDao.selectTotalCount();
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return LayUITableJSONResult.ok((int) totalCount,list);
    }

    @Override
    public JSONResult deleteById(int id) {
        int result = 0;
        String str = "";
        try {
            DbUtils.begin();
            result = userDao.deleteById(id);
            if(result != 0) {
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
                result = userDao.deleteById(Integer.parseInt(id));
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
    public JSONResult add(User user) {
        int result = 0;
        String str = "";
        try {
            DbUtils.begin();
            result = userDao.add(user);
            if (result != 0){
                str = "添加成功！";
            } else {
                str = "添加失败";
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return JSONResult.ok(str);
    }


    @Override
    public User selectById(int id) {
        User user = null;

        try {
            DbUtils.begin();
            User temp = userDao.selectById(id);
            if(temp!=null){
                user = temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public JSONResult update(User user) {
        int result = 0;
        String str = "";
        try {
            DbUtils.begin();
            result = userDao.update(user);
            if (result != 0){
                str = "修改成功！";
            } else {
                str = "修改失败";
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return JSONResult.ok(str);
    }
}

