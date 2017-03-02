package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Condition;
import ru.ocean.animals.service.ConditionService;

@Controller
public class ConditionController {

    @Autowired
    private ConditionService conditionService;

    @RequestMapping(value = "/conditions", method = RequestMethod.GET)
    public String getConditions(Model model) {
        model.addAttribute("condition",        new Condition());
        model.addAttribute("listConditions",    this.conditionService.getConditions());

        return "condition";
    }

    @RequestMapping(value = "/condition/add", method = RequestMethod.POST)
    public String addCondition(@ModelAttribute("condition") Condition condition) {
        if(condition.getId() == null) {
            this.conditionService.addCondition(condition);
        } else {
            this.conditionService.updateCondition(condition);
        }

        return "redirect:/conditions";
    }

    @RequestMapping(value = "/condition/remove/{id}")
    public String removeCondition(@PathVariable("id") long id) {
        this.conditionService.removeCondition(id);

        return "redirect:/conditions";
    }

    @RequestMapping(value = "/condition/edit/{id}")
    public String editCondition(@PathVariable("id") long id, Model model) {
        model.addAttribute("condition",         this.conditionService.getConditionById(id));
        model.addAttribute("listConditions",    this.conditionService.getConditions());

        return "condition";
    }

}
