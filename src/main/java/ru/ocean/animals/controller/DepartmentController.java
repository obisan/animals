package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Department;
import ru.ocean.animals.service.DepartmentService;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String getDepartments(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("listDepartments", this.departmentService.getDepartments());

        return "department";
    }

    @RequestMapping(value = "/department/add", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute("department") Department department) {
        if(department.getId() == null) {
            this.departmentService.addDepartment(department);
        } else {
            this.departmentService.updateDepartment(department);
        }

        return "redirect:/departments";
    }

    @RequestMapping(value = "/department/remove/{id}")
    public String removeDepartment(@PathVariable("id") long id){
        this.departmentService.removeDepartment(id);

        return "redirect:/departments";
    }

    @RequestMapping(value = "/department/edit/{id}")
    public String editDepartment(@PathVariable("id") long id, Model model) {
        model.addAttribute("department", this.departmentService.getDepartmentById(id));
        model.addAttribute("listDepartments", this.departmentService.getDepartments());

        return "department";
    }

    @RequestMapping(value = "/department/info/{id}")
    public String infoDepartment(@PathVariable("id") long id, Model model) {
        model.addAttribute("department",    this.departmentService.getDepartmentById(id));

        return "info/department";
    }
}
