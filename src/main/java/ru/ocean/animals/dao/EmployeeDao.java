package ru.ocean.animals.dao;

import ru.ocean.animals.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void                addEmployee(Employee employee);
    void                updateEmployee(Employee employee);
    Employee            getEmployeeById(long id);
    List<Employee>      getEmployees();
    void                removeEmployee(long id);
}
