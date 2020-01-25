package com.nga.springboot.restcruddemo.dao;

import com.nga.springboot.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
