package com.situ.web.pojo;

public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String object;
    private Integer salary;

    public Teacher(Integer id, String name, Integer age, String object, Integer salary,String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.object = object;
        this.salary = salary;
    }

    public Teacher(String name, Integer age,  String object, Integer salary ,String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.object = object;
        this.salary = salary;
    }

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Teacher(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getObject() { return object; }

    public void setObject(String object) { this.object = object; }

    public Integer getSalary() { return salary; }

    public void setSalary(Integer salary) { this.salary = salary; }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", object='" + object + '\'' +
                ", salary=" + salary +
                '}';
    }
}
