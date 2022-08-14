package com.lyy.emp.service.impl;

import com.lyy.emp.dao.EmpDao;
import com.lyy.emp.dao.impl.EmpDaoImpl;
import com.lyy.emp.entity.Emp;
import com.lyy.emp.entity.Page;
import com.lyy.emp.service.EmpService;
import com.lyy.emp.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public List<Emp> showAllEmp() {
        List<Emp> emps = new ArrayList<>();

        try {
            DbUtils.begin();
            List<Emp> temps = empDao.selectAll();
            if(temps!=null){
                emps = temps;
            }

            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public int removeEmp(int id) {
        int result = 0;

        try {
            DbUtils.begin();
            result = empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(Emp emp) {
        int result = 0;

        try {
            DbUtils.begin();
            result = empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emp showEmp(int id) {
        Emp emp = null;

        try {
            DbUtils.begin();
            Emp temp = empDao.select(id);

            if(temp!=null){
                emp = temp;
            }

            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public List<Emp> showAllEmp(Page page) {
        List<Emp> emps = new ArrayList<>();

        try {
            DbUtils.begin();
            long count = empDao.selectCount();
            page.setTotalCounts((int)count);
            List<Emp> temps = empDao.selectAll(page);
            if(temps!=null){
                emps = temps;
            }

            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }
}
