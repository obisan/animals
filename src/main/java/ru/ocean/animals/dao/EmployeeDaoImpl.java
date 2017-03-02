package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("Employee successfully added. Employee details: " + employee);
    }

    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
        logger.info("Employee successfully updated. Employee details: " + employee);
    }

    public Employee getEmployeeById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = (Employee) session.load(Employee.class, new Long(id));
        logger.info("Employee successfully updated. Employee details: " + employee);
        return employee;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> employees = session.createQuery("from Employee").list();
        for (Employee employee : employees) {
            logger.info("Employee successfully updated. Employee details: " + employee);
        }
        return employees;
    }

    public void removeEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = (Employee) session.load(Employee.class, new Long(id));
        if(employee != null) {
            session.delete(employee);
        }
        logger.info("Employee successfully updated. Employee details: " + employee);
    }
}
