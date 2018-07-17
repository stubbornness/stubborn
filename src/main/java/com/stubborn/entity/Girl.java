package com.stubborn.entity;

/**
 * 女生
 *
 * @author 丁少东
 * @create 2018-07-17 上午10:40
 **/
public class Girl {
    private long id;
    private String name;
    private int age;
    private double salary;
    private String address;

    public Girl() {

    }

    public Girl(long id, String name, int age, double salary, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
