package com.nga.springboot.restcruddemo.service;

import com.nga.springboot.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
