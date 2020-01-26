package com.nga.springboot.restcruddemo.dao;

import com.nga.springboot.restcruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        Query query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void deleteById(int id) {

    }
}
