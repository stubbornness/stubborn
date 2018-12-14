package com.stubborn.entity;

/**
 * @author 丁少东
 * @create 2018-10-29 下午3:22
 **/
public class Employee {
    private String id;
    private String name;
    private Integer age;
    private Double salary;

    public Employee() {
    }

    public Employee(String id, String name, Integer age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
