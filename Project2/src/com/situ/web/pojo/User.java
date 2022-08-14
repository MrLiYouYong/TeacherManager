package com.situ.web.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String address;
    private String gender;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User() {
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(Integer id,String name, String password, Integer age, String address, String gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public User(String name, String password, Integer age, String address,String gender) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public User(Integer id, String name, String password, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
