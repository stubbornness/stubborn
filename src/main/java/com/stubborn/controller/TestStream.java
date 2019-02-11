package com.stubborn.controller;

import com.stubborn.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

/**
 * @author 丁少东
 * @create 2018-10-29 下午3:21
 **/
public class TestStream {
    public static void main(String[] args) {
    /* *//*   List<Employee> list = new ArrayList<>();
        list.add(new Employee("001","jack",23,5000.00));
        list.add(new Employee("002","tom",21,3000.00));
        list.add(new Employee("003","bob",24,8000.00));
        list.add(new Employee("004","lily",26,4000.00));
        List<Employee> lists = list.stream().filter(x->"jack".equals(x.getName())).collect(toList());*//*

        Employee employee = new Employee("001","jack",23,5000.00);
        Employee employee1 = employee;
        employee.equals(employee1);
        String empName = "jack";
        empName.equals(employee.getName());*/
        //System.out.println(new Random().nextInt(0));
        String empName = "jack";
        empName.equals("123");
    }
}
