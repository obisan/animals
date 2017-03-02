package ru.ocean.animals.service;

import ru.ocean.animals.model.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    void updateDepartment(Department department);
    Department getDepartmentById(long id);
    List<Department> getDepartments();
    void removeDepartment(long id);
}
