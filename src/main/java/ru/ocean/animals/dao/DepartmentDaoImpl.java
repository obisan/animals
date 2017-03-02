package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Department;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(department);
        logger.info("Department successfully added. Department details: " + department);
    }

    public void updateDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.update(department);
        logger.info("Department successfully updated. Department details: " + department);
    }

    public Department getDepartmentById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = (Department) session.load(Department.class, new Long(id));
        logger.info("Department successfully loaded. Department details: " + department);
        return department;
    }

    @SuppressWarnings("unchecked")
    public List<Department> getDepartments() {
        Session session = sessionFactory.getCurrentSession();

        List<Department> departments = session.createQuery("from Department ORDER BY department_name ASC").list();
        for(Department department : departments) {
            logger.info("Department successfully loaded. Department details: " + department);
        }
        return departments;
    }

    public void removeDepartment(long id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = (Department) session.load(Department.class, new Long(id));

        if(department != null) {
            session.delete(department);
        }

        logger.info("Department successfully removed. Department details: " + department);
    }
}
