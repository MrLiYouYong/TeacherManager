package com.situ.spring.controller;

import com.situ.spring.service.IStudentService;
import com.situ.spring.service.impl.StudentServiceImpl;

public class StudentController {
    // private IStudentService studentService = new StudentServiceImpl();
    private IStudentService studentService;

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    public void selectAll() {
        System.out.println("StudentController.selectAll");
        studentService.selectAll();
    }
}
