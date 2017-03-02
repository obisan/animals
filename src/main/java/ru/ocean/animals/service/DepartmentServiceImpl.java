package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.DepartmentDao;
import ru.ocean.animals.model.Department;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional("dubinets")
    public void addDepartment(Department department) {
        this.departmentDao.addDepartment(department);
    }

    @Transactional("dubinets")
    public void updateDepartment(Department department) {
        this.departmentDao.updateDepartment(department);
    }

    @Transactional("dubinets")
    public Department getDepartmentById(long id) {
        return this.departmentDao.getDepartmentById(id);
    }

    @Transactional("dubinets")
    public List<Department> getDepartments() {
        return this.departmentDao.getDepartments();
    }

    @Transactional("dubinets")
    public void removeDepartment(long id) {
        this.departmentDao.removeDepartment(id);
    }
}
