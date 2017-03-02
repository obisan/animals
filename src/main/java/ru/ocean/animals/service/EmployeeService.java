package ru.ocean.animals.service;

import ru.ocean.animals.model.Employee;

import java.util.List;

public interface EmployeeService {
    void            addEmployee(Employee employee);
    void            updateEmployee(Employee employee);
    Employee        getEmployeeById(long id);
    List<Employee>  getEmployees();
    void            removeEmployee(long id);
}
