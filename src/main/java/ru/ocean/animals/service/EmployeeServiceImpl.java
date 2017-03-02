package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.EmployeeDao;
import ru.ocean.animals.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional("dubinets")
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Transactional("dubinets")
    public void updateEmployee(Employee employee) {
        this.employeeDao.updateEmployee(employee);
    }

    @Transactional("dubinets")
    public Employee getEmployeeById(long id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Transactional("dubinets")
    public List<Employee> getEmployees() {
        return this.employeeDao.getEmployees();
    }

    @Transactional("dubinets")
    public void removeEmployee(long id) {
        this.employeeDao.removeEmployee(id);
    }
}
