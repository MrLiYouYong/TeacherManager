package com.situ.web.dao;

import com.situ.web.pojo.User;

import java.util.List;

public interface IUserDao {
    List<User> selectPage(Integer offset, Integer limit);
    Long selectTotalCount();

    int deleteById(int id);

    int add(User user);

    User selectById(int id);

    int update(User user);
}
