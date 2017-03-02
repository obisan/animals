package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Drug;
import ru.ocean.animals.service.DrugService;

@Controller
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "/drugs", method = RequestMethod.GET)
    public String getDrugs(Model model) {
        model.addAttribute("drug", new Drug());
        model.addAttribute("listDrugs", this.drugService.getDrugs());

        return "drug";
    }

    @RequestMapping(value = "/drug/add", method = RequestMethod.POST)
    public String addDrugs(@ModelAttribute("drug") Drug drug) {
        if(drug.getId() == null) {
            this.drugService.addDrug(drug);
        } else {
            this.drugService.updateDrug(drug);
        }
        return "redirect:/drugs";
    }

    @RequestMapping(value = "/drug/remove/{id}")
    public String removeDrug(@PathVariable("id") long id) {
        this.drugService.removeDrug(id);

        return "redirect:/drugs";
    }

    @RequestMapping(value = "/drug/edit/{id}")
    public String editDrug(@PathVariable("id") long id, Model model) {
        model.addAttribute("drug",      this.drugService.getDrugById(id));
        model.addAttribute("listDrugs", this.drugService.getDrugs());

        return "drug";
    }

}
