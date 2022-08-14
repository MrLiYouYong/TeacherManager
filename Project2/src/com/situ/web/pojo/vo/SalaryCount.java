package com.situ.web.pojo.vo;

public class SalaryCount {
    private Integer salary;
    private Integer count;

    public SalaryCount(Integer salary, Integer count) {
        this.salary = salary;
        this.count = count;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SalaryCount{" +
                "salary=" + salary +
                ", count=" + count +
                '}';
    }
}
