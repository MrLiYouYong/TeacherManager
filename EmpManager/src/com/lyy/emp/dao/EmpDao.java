package com.lyy.emp.dao;

import com.lyy.emp.entity.Emp;
import com.lyy.emp.entity.Page;

import java.util.List;

public interface EmpDao {

    public List<Emp> selectAll();

    public int delete(int id);

    public int update(Emp emp);

    public Emp select(int id);

    public List<Emp> selectAll(Page page);

    public long selectCount();
}
