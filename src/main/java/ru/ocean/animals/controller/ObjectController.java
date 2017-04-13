package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ocean.animals.model.ObjectExtended;
import ru.ocean.animals.model.Specie;
import ru.ocean.animals.service.*;
import ru.ocean.animals.validator.ObjectValidator;

@Controller
public class ObjectController {

    @Autowired
    private ObjectService       objectService;

    @Autowired
    private DepartmentService   departmentService;

    @Autowired
    private LabelService        labelService;

    @Autowired
    private TagService          tagService;

    @Autowired
    private SpecieService       specieService;

    @Autowired
    private TankService         tankService;

    @Autowired
    private AquariumService     aquariumService;

    @Autowired
    private ConditionService    conditionService;

    @Autowired
    private ObjectValidator     objectValidator;

    @RequestMapping(value = "/objects")
    public String getObject(@RequestParam(value = "specie", required = false) String specie, Model model) {
        model.addAttribute("object",        new ObjectExtended());
        model.addAttribute("listObjects",   this.objectService.getObjectsAlive());

        if(specie == null) {
            model.addAttribute("listObjects",   this.objectService.getObjectsAliveWithoutParents());
        }
        else {
            model.addAttribute("listObjects",   this.objectService.getObjectsFilteredBySpecieId(Long.parseLong(specie)));
        }

        model.addAttribute("listDepartments",   this.departmentService.getDepartments());
        model.addAttribute("listLabels",        this.labelService.getLabels());
        model.addAttribute("listTags",          this.tagService.getTags());
        model.addAttribute("listSpecies",       this.specieService.getSpecies());
        model.addAttribute("listTanks",         this.tankService.getTanks());
        model.addAttribute("listAquariums",     this.aquariumService.getAquariums());
        model.addAttribute("listConditions",    this.conditionService.getConditions());
        model.addAttribute("specie",            new Specie());

        return "object";
    }

    @RequestMapping(value = "/object/add", method = RequestMethod.POST)
    public String addObject(@ModelAttribute("object") ObjectExtended object, BindingResult bindingResult, Model model) {
        objectValidator.validate(object, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("listObjects",       this.objectService.getObjectsAliveWithoutParents());
            model.addAttribute("listDepartments",   this.departmentService.getDepartments());
            model.addAttribute("listLabels",        this.labelService.getLabels());
            model.addAttribute("listTags",          this.tagService.getTags());
            model.addAttribute("listSpecies",       this.specieService.getSpecies());
            model.addAttribute("listTanks",         this.tankService.getTanks());
            model.addAttribute("listAquariums",     this.aquariumService.getAquariums());
            model.addAttribute("listConditions",    this.conditionService.getConditions());

            return "object";
        }

        if(object.getObject().getId() == null) {
            this.objectService.addObjectExtended(object);
        } else {
            this.objectService.updateObjectExtended(object);
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
        model.addAttribute("object",            this.objectService.getObjectById(id));
        model.addAttribute("listObjects",       this.objectService.getObjectsAliveWithoutParents());
        model.addAttribute("listDepartments",   this.departmentService.getDepartments());
        model.addAttribute("listLabels",        this.labelService.getLabels());
        model.addAttribute("listTags",          this.tagService.getTags());
        model.addAttribute("listSpecies",       this.specieService.getSpecies());
        model.addAttribute("listTanks",         this.tankService.getTanks());
        model.addAttribute("listAquariums",     this.aquariumService.getAquariums());
        model.addAttribute("listConditions",    this.conditionService.getConditions());

        return "object";
    }

    @RequestMapping(value = "/object/info/{id}")
    public String infoObject(@PathVariable("id") long id, Model model) {
        model.addAttribute("object",            this.objectService.getObjectById(id));
        model.addAttribute("objectQuarantines", this.objectService.getQuarantinesOfObject(id));

        return "info/object";
    }
}
