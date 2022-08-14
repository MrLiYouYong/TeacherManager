package com.situ.ssm.controller;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.service.impl.StudentServiceImpl;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private IStudentService studentService = new StudentServiceImpl();

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Student> selectAll() {
        List<Student> list = studentService.selectAll();
        return list;
    }
}
