package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ocean.animals.model.Object;
import ru.ocean.animals.model.Specie;
import ru.ocean.animals.service.*;
import ru.ocean.animals.validator.ObjectValidator;

@Controller
public class ObjectController {

    @Autowired
    private ObjectService       objectService;

    @Autowired
    private EmployeeService     employeeService;

    @Autowired
    private LabelService        labelService;

    @Autowired
    private TagService          tagService;

    @Autowired
    private SpecieService       specieService;

    @Autowired
    private TankService         tankService;

    @Autowired
    private ObjectValidator     objectValidator;

    @RequestMapping(value = "/objects")
    public String getObject(@RequestParam(value = "specie", required = false) String specie, Model model) {
        model.addAttribute("object",        new Object());
        model.addAttribute("listObjects",   this.objectService.getObjectsAlive());

        if(specie == null) {
            model.addAttribute("listObjects",   this.objectService.getObjectsAliveWithoutParents());
        }
        else {
            model.addAttribute("listObjects",   this.objectService.getObjectsFilteredBySpecieId(Long.parseLong(specie)));
        }

        model.addAttribute("listEmployees", this.employeeService.getEmployees());
        model.addAttribute("listLabels",    this.labelService.getLabels());
        model.addAttribute("listTags",      this.tagService.getTags());
        model.addAttribute("listSpecies",   this.specieService.getSpecies());
        model.addAttribute("listTanks",     this.tankService.getTanks());
        model.addAttribute("specie",        new Specie());

        return "object";
    }

    @RequestMapping(value = "/object/add", method = RequestMethod.POST)
    public String addObject(@ModelAttribute("object") Object object, BindingResult bindingResult, Model model) {
        objectValidator.validate(object, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("listObjects",   this.objectService.getObjectsAliveWithoutParents());
            model.addAttribute("listEmployees", this.employeeService.getEmployees());
            model.addAttribute("listLabels",    this.labelService.getLabels());
            model.addAttribute("listTags",      this.tagService.getTags());
            model.addAttribute("listSpecies",   this.specieService.getSpecies());
            model.addAttribute("listTanks",     this.tankService.getTanks());

            return "object";
        }

        if(object.getId() == null) {
            this.objectService.addObject(object);
        } else {
            this.objectService.updateObject(object);
        }

        return "redirect:/objects";
    }

    @RequestMapping(value = "/object/remove/{id}")
    public String removeObject(@PathVariable("id") long id) {
        this.objectService.removeObject(id);

        return "redirect:/objects";
    }

    @RequestMapping(value = "/object/edit/{id}")
    public String editObject(@PathVariable("id") long id, Model model) {
        model.addAttribute("object",        this.objectService.getObjectById(id));
        model.addAttribute("listObjects",   this.objectService.getObjectsAlive());
        model.addAttribute("listEmployees", this.employeeService.getEmployees());
        model.addAttribute("listLabels",    this.labelService.getLabels());
        model.addAttribute("listTags",      this.tagService.getTags());
        model.addAttribute("listSpecies",   this.specieService.getSpecies());
        model.addAttribute("listTanks",     this.tankService.getTanks());

        return "object";
    }

    @RequestMapping(value = "/object/info/{id}")
    public String infoObject(@PathVariable("id") long id, Model model) {
        model.addAttribute("object",            this.objectService.getObjectById(id));
        model.addAttribute("objectQuarantines", this.objectService.getQuarantinesOfObject(id));

        return "info/object";
    }
}
