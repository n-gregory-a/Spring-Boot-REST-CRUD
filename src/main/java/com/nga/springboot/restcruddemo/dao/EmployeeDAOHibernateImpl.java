package com.nga.springboot.restcruddemo.dao;

import com.nga.springboot.restcruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        // execute, get result list and return it
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // get the employee and return it
        return session.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // save employee
        session.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int id) {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
