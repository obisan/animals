package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Employee;
import ru.ocean.animals.service.DepartmentService;
import ru.ocean.animals.service.EmployeeService;
import ru.ocean.animals.service.ObjectService;

@Controller
public class EmployeeController {

    @Autowired
    private ObjectService       objectService;

    @Autowired
    private EmployeeService     employeeService;

    @Autowired
    private DepartmentService   departmentService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String getEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.getEmployees());
        model.addAttribute("listDepartments", this.departmentService.getDepartments());

        return "employee";
    }

    @RequestMapping(value = "/employee/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if(employee.getId() == null) {
            this.employeeService.addEmployee(employee);
        } else {
            this.employeeService.updateEmployee(employee);
        }

        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee/remove/{id}")
    public String removeEmployee(@PathVariable("id") long id) {
        this.employeeService.removeEmployee(id);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee/edit/{id}")
    public String editEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee",          this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees",     this.employeeService.getEmployees());
        model.addAttribute("listDepartments",   this.departmentService.getDepartments());

        return "employee";
    }

    @RequestMapping(value = "/employee/info/{id}")
    public String infoEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee",      this.employeeService.getEmployeeById(id));
        model.addAttribute("listObjects",   this.objectService.getObjectsAliveWithoutParentsByEmployee(id));

        return "info/employee";
    }

}
