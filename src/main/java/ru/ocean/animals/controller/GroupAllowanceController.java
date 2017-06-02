package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.GroupAllowance;
import ru.ocean.animals.service.GroupAllowanceService;

@Controller
public class GroupAllowanceController {

    @Autowired
    private GroupAllowanceService           groupAllowanceService;

    @RequestMapping(value = "/groupallowances", method = RequestMethod.GET)
    public String getGroupAllowances(Model model) {
        model.addAttribute("groupallowance", new GroupAllowance());
        model.addAttribute("listGroupAllowances", this.groupAllowanceService.getGroupAllowances());

        return "groupallowance";
    }

    public String addGroupAllowance(@ModelAttribute("groupallowance") GroupAllowance groupAllowance) {
        if(groupAllowance.getId() == null) {
            this.groupAllowanceService.addGroupAllowance(groupAllowance);
        } else {
            this.groupAllowanceService.updateGroupAllowance(groupAllowance);
        }

        return "redirect:/groupallowances";
    }

    @RequestMapping(value = "/groupallowance/remove/{id}")
    public String removeGroupAllowance(@PathVariable("id") long id) {
        this.groupAllowanceService.removeGroupAllowance(id);

        return "redirect:/groupallowances";
    }

    @RequestMapping(value = "/groupallowance/edit/{id}")
    public String editGroupAllowance(@PathVariable("id") long id, Model model) {
        model.addAttribute("groupallowance",        this.groupAllowanceService.getGroupAllowanceById(id));
        model.addAttribute("listGroupAllowances",   this.groupAllowanceService.getGroupAllowances());

        return "groupallowance";
    }

}
