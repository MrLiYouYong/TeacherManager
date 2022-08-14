package com.lyy.emp.service;

import com.lyy.emp.entity.Emp;
import com.lyy.emp.entity.Page;

import java.util.List;

public interface EmpService {

    public List<Emp> showAllEmp();

    public int removeEmp(int id);

    public int modify(Emp emp);

    public Emp showEmp(int id);

    public List<Emp> showAllEmp(Page page);
}
