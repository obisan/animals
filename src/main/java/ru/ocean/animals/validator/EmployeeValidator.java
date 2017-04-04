package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Employee;
import ru.ocean.animals.service.EmployeeService;

@Component
public class EmployeeValidator implements Validator {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee employee = (Employee) o;

        if(employee.getEmployee_last_name().equals("")) {
            errors.rejectValue("employee_last_name", "Null.value");
        }

        if(employee.getEmployee_first_name().equals("")) {
            errors.rejectValue("employee_first_name", "Null.value");
        }

        if(employee.getEmployee_middle_name().equals("")) {
            errors.rejectValue("employee_middle_name", "Null.value");
        }

    }
}
