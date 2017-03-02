package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Label;
import ru.ocean.animals.service.ConditionService;
import ru.ocean.animals.service.LabelService;

@Controller
public class LabelController {

    @Autowired
    private LabelService        labelService;

    @Autowired
    private ConditionService    conditionService;

    @RequestMapping(value = "/labels", method = RequestMethod.GET)
    public String getLabels(Model model) {
        model.addAttribute("label",             new Label());
        model.addAttribute("listLabels",        this.labelService.getLabels());
        model.addAttribute("listConditions",    this.conditionService.getConditions());

        return "label";
    }

    @RequestMapping(value = "/label/add", method = RequestMethod.POST)
    public String addLabel(@ModelAttribute("label") Label label) {
        if(label.getId() == null) {
            this.labelService.addLabel(label);
        } else {
            this.labelService.updateLabel(label);
        }

        return "redirect:/labels";
    }

    @RequestMapping(value = "/label/remove/{id}")
    public String removeLabel(@PathVariable("id") long id) {
        this.labelService.removeLabel(id);

        return "redirect:/labels";
    }

    @RequestMapping(value = "/label/edit/{id}")
    public String editLabel(@PathVariable("id") long id, Model model) {
        model.addAttribute("label",             this.labelService.getLabelById(id));
        model.addAttribute("listLabels",        this.labelService.getLabels());
        model.addAttribute("listConditions",    this.conditionService.getConditions());

        return "label";
    }


}
