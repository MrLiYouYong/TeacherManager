package com.situ.mybatis.test;

import com.situ.mybatis.pojo.Banji;
import com.situ.mybatis.pojo.Student;
import com.situ.mybatis.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectById1() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建 SqlSessionFactory    Session:会话 (连接数据库后就建立了一次会话，有了会话就可以操作数据库)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行Sql语句
        Student student = sqlSession.selectOne("student.selectById", 2);
        System.out.println(student);
    }

    @Test
    public void testSelectById2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = sqlSession.selectOne("student.selectById", 2);
        System.out.println(student);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> list = sqlSession.selectList("student.selectAll");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testDeleteById() {
        // Setting autocommit to false on JDBC Connection
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int count = sqlSession.delete("student.deleteById", 12);
        System.out.println(count);
        // 对于更新类的操作需要手动提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = new Student();
        student.setName("王五");
        student.setAge(23);
        student.setGender("男");
        student.setBanjiId(1);
        int count = sqlSession.insert("student.add", student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = new Student();
        student.setId(41);
        student.setName("王五2");
        student.setAge(24);
        student.setGender("女");
        student.setBanjiId(2);
        int count = sqlSession.insert("student.update", student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByPage() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int pageNo = 2;
        int pageSize = 3;
        int offset = (pageNo - 1) * pageSize;
        Map<String, Object> map = new HashMap<>();
        map.put("offset", offset);
        map.put("pageSize", pageSize);
        List<Student> list = sqlSession.selectList("student.selectByPage", map);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectTotalCount() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int count = sqlSession.selectOne("student.selectTotalCount");
        System.out.println("count: " + count);
    }

    @Test
    public void testSelectStudentBanjiInfo() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> list = sqlSession.selectList("student.selectStudentBanjiInfo");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectBanjiStudentInfo() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Banji> list = sqlSession.selectList("banji.selectBanjiStudentInfo");
        for (Banji banji : list) {
            System.out.println(banji);
            List<Student> studentList = banji.getList();
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    @Test
    public void testselectByCondition() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student stu = new Student();
        stu.setName("王");
        stu.setGender("女");
        List<Student> list = sqlSession.selectList("student.selectByCondition", stu);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testUpdateCondition() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = new Student();
        student.setId(4);
        // student.setName("Admin2");
        student.setAge(25);
        student.setGender("n");
        int count = sqlSession.update("student.updateCondition", student);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testDeleteAllByArray() {
        int[] array = {41, 42};
        SqlSession sqlSession = MyBatisUtil.getSqlSession();;
        int count = sqlSession.update("student.deleteAllByArray", array);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteAllByList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(37);
        list.add(38);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int count = sqlSession.update("student.deleteAllByList", list);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() {
        Student stu = new Student();
        //stu.setName("王");
        stu.setAge(23);
        stu.setGender("女");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> list = sqlSession.selectList("student.selectByCondition1", stu);
        for (Student student : list) {
            System.out.println(student);
        }
    }

}
