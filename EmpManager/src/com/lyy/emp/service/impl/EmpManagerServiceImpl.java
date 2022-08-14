package com.lyy.emp.service.impl;

import com.lyy.emp.dao.EmpManagerDao;
import com.lyy.emp.dao.impl.EmpManagerDaoImpl;
import com.lyy.emp.entity.EmpManager;
import com.lyy.emp.service.EmpManagerService;
import com.lyy.emp.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {

    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl();
    @Override
    public EmpManager login(String username, String password) {

        EmpManager empManager = null;

        try {
            DbUtils.begin();
            EmpManager temp = empManagerDao.select(username);
            if(temp!=null){
                if(temp.getPassword().equals(password)){
                    empManager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empManager;
    }































}
