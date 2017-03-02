package ru.ocean.animals.dao;

import ru.ocean.animals.model.Department;

import java.util.List;

public interface DepartmentDao {
    void addDepartment(Department department);
    void updateDepartment(Department department);
    Department getDepartmentById(long id);
    List<Department> getDepartments();
    void removeDepartment(long id);
}
