package com.situ.web.pojo;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer banji_id;

    public Student(String name, Integer age, String gender, Integer banji_id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.banji_id = banji_id;
    }

    public Student(Integer id, String name, Integer age, String gender, Integer banji_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.banji_id = banji_id;
    }

    public Integer getBanji_id() {
        return banji_id;
    }

    public void setBanji_id(Integer banji_id) {
        this.banji_id = banji_id;
    }

    public Student() {
    }

    public Student(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
