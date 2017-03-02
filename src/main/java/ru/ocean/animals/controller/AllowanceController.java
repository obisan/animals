package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Allowance;
import ru.ocean.animals.service.AllowanceService;

@Controller
public class AllowanceController {

    @Autowired
    private AllowanceService allowanceService;

    @RequestMapping(value = "/allowances", method = RequestMethod.GET)
    public String getAllowances(Model model) {
        model.addAttribute("allowance", new Allowance());
        model.addAttribute("listAllowances", this.allowanceService.getAllowances());

        return "allowance";
    }

    @RequestMapping(value = "/allowance/add", method = RequestMethod.POST)
    public String addAllowance(@ModelAttribute("allowance") Allowance allowance) {
        if(allowance.getId() == null) {
            this.allowanceService.addAllowance(allowance);
        } else {
            this.allowanceService.updateAllowance(allowance);
        }

        return "redirect:/allowances";
    }

    @RequestMapping(value = "/allowance/remove/{id}")
    public String removeAllowance(@PathVariable("id") long id) {
        this.allowanceService.removeAllowance(id);

        return "redirect:/allowances";
    }

    @RequestMapping(value = "/allowance/edit/{id}")
    public String editAllowance(@PathVariable("id") long id, Model model) {
        model.addAttribute("allowance",         this.allowanceService.getAllowanceById(id));
        model.addAttribute("listAllowances",    this.allowanceService.getAllowances());

        return "allowance";
    }

}
