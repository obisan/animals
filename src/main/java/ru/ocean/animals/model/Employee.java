package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_first_name")
    private String employee_first_name;

    @Column(name = "employee_last_name")
    private String employee_last_name;

    @Column(name = "employee_middle_name")
    private String employee_middle_name;

    @Column(name = "employee_title")
    private String employee_title;

    @Column(name = "department_id")
    private Long department_id;

    @ManyToOne
    @JoinColumn(
            name = "department_id",
            foreignKey = @ForeignKey(name = "FK_Employee_Department"),
            insertable = false,
            updatable = false)
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_first_name() {
        return employee_first_name;
    }

    public void setEmployee_first_name(String employee_first_name) {
        this.employee_first_name = employee_first_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public String getEmployee_middle_name() {
        return employee_middle_name;
    }

    public void setEmployee_middle_name(String employee_middle_name) {
        this.employee_middle_name = employee_middle_name;
    }

    public String getEmployee_title() {
        return employee_title;
    }

    public void setEmployee_title(String employee_title) {
        this.employee_title = employee_title;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String   getFullName() {
        return employee_last_name + employee_first_name + employee_middle_name;
    }

    public String   getFullShortName() {
        return  employee_last_name + " "
                + employee_first_name.substring(0,1) + ". "
                + employee_middle_name.substring(0,1) + ".";
    }

    public String   getFullShortNameAndDepartment() {
        return getFullShortName() + " (" + department.getDepartment_name() + ")";
    }

    public String   getFullShortNameAndTitle() {
        return getFullShortName() + " (" + employee_title + ")";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employee_first_name='" + employee_first_name + '\'' +
                ", employee_last_name='" + employee_last_name + '\'' +
                ", employee_middle_name='" + employee_middle_name + '\'' +
                ", employee_title='" + employee_title + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
