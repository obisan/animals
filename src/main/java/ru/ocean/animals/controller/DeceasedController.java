package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.service.DeceasedService;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.validator.DeceasedValidator;

@Controller
public class DeceasedController {

    @Autowired
    private DeceasedService     deceasedService;

    @Autowired
    private ObjectService       objectService;

    @Autowired
    private DeceasedValidator   deceasedValidator;

    @RequestMapping(value = "/deceaseds",   method = RequestMethod.GET)
    public String getDeceaseds(Model model) {
        model.addAttribute("deceased",          new Deceased());
        model.addAttribute("listDeceaseds",     this.deceasedService.getDeceaseds());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());

        return "deceased";
    }

    @RequestMapping(value = "/deceased/add", method = RequestMethod.POST)
    public String addDeceased(@ModelAttribute("deceased") Deceased deceased, BindingResult bindingResult, Model model) {
        deceasedValidator.validate(deceased, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("listDeceaseds",     this.deceasedService.getDeceaseds());
            model.addAttribute("listObjects",       this.objectService.getObjectsAlive());

            return "deceased";
        }

        if(deceased.getId() == null) {
            this.deceasedService.addDeceased(deceased);
        } else {
            this.deceasedService.updateDeceased(deceased);
        }

        return "redirect:/deceaseds";
    }

    @RequestMapping(value = "/deceased/remove/{id}")
    public String removeDeceased(@PathVariable("id") long id) {
        this.deceasedService.removeDeceased(id);

        return "redirect:/deceaseds";
    }

    @RequestMapping(value = "/deceased/edit/{id}")
    public String editDeceased(@PathVariable("id") long id, Model model) {
        model.addAttribute("deceased",      this.deceasedService.getDeceasedById(id));
        model.addAttribute("listDeceaseds", this.deceasedService.getDeceaseds());
        model.addAttribute("listObjects",   this.objectService.getObjectsAlive());

        return "deceased";
    }

}
