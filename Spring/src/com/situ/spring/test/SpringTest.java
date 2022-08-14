package com.situ.spring.test;

import com.situ.spring.controller.StudentController;
import com.situ.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test1() {
        // 创建Spring容器，在xml中配置的bean都会new出对象放到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从Spring容器中根据名字取出指定new出来的对象
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test2() {
        // 创建Spring容器，在xml中配置的bean都会new出对象放到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从Spring容器中根据名字取出指定new出来的对象
        //Student student1 = (Student) context.getBean("student");
        //Student student2 = (Student) context.getBean("student");
        //System.out.println(student1 == student2);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) context.getBean("studentController");
        studentController.selectAll();
    }
}
