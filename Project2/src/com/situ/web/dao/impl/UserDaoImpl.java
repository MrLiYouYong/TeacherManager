package com.situ.web.dao.impl;

import com.situ.web.dao.IUserDao;
import com.situ.web.pojo.User;
import com.situ.web.util.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<User> selectPage(Integer offset, Integer limit) {
        List<User> list = null;
        try {
            list = queryRunner.query(DbUtils.getConnection(),"select * from users limit ?,?;",new BeanListHandler<User>(User.class),offset,limit);
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
            result = queryRunner.query(DbUtils.getConnection(),"select count(*) from users",new ScalarHandler<>());
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
            result = queryRunner.update(DbUtils.getConnection(),"delete from users where id=?",id);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int add(User user) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection(),"insert into users(name,password, age, address, gender) values(?,?,?,?,?)"
                    ,user.getName(),user.getPassword(),user.getAge(),user.getAddress(),user.getGender());
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public User selectById(int id) {
        try {
            User user= queryRunner.query(DbUtils.getConnection(),"select * from users where id=?",new BeanHandler<User>(User.class),id);
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(User user) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection(),"update users set name=?,password=?,age=?,address=?,gender=? where id=? "
                    ,user.getName(),user.getPassword(),user.getAge(),user.getAddress(),user.getGender(),user.getId());
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
