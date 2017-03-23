package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Drug;
import ru.ocean.animals.model.VitaminizationExtended;
import ru.ocean.animals.service.DrugService;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.service.TankService;
import ru.ocean.animals.service.VitaminizationService;

@Controller
public class VitaminizationController {

    @Autowired
    private VitaminizationService   vitaminizationService;

    @Autowired
    private DrugService             drugService;

    @Autowired
    private ObjectService           objectService;

    @Autowired
    private TankService             tankService;

    @RequestMapping(value = "/vitaminizations", method = RequestMethod.GET)
    public String getVitaminizations(Model model) {
        model.addAttribute("vitaminization",        new VitaminizationExtended());
        model.addAttribute("drug1",     new Drug());
        model.addAttribute("drug2",     new Drug());
        model.addAttribute("drug3",     new Drug());
        model.addAttribute("drug4",     new Drug());
        model.addAttribute("drug5",     new Drug());
        model.addAttribute("drug6",     new Drug());
        model.addAttribute("drug7",     new Drug());
        model.addAttribute("drug8",     new Drug());
        model.addAttribute("drug9",     new Drug());
        model.addAttribute("drug10",    new Drug());

        model.addAttribute("listVitaminizations",   this.vitaminizationService.getVitaminizations());
        model.addAttribute("listObjects",           this.objectService.getObjectsAliveWithoutParents());
        model.addAttribute("listDrugs",             this.drugService.getVitamines());
        model.addAttribute("listTanks",             this.tankService.getTanks());

        return "vitaminization";
    }

    @RequestMapping(value = "/vitaminization/add", method = RequestMethod.POST)
    public String addVitaminization(@ModelAttribute("vitaminization") VitaminizationExtended vitaminization) {
        if(vitaminization.getVitaminization().getId() == null) {
            this.vitaminizationService.addVitaminization(vitaminization);
        } else {

        }

        return "redirect:/vitaminizations";
    }

    @RequestMapping(value = "/vitaminization/remove/{id}")
    public String removeVitaminization(@PathVariable("id") long id) {
        this.vitaminizationService.removeVitaminization(id);

        return "redirect:/vitaminizations";
    }

    @RequestMapping(value = "/vitaminization/edit/{id}")
    public String editVitaminization(@PathVariable("id") long id, Model model) {
        model.addAttribute("vitaminization",        this.vitaminizationService.getVitaminizationExtendedById(id));
        model.addAttribute("listVitaminizations",   this.vitaminizationService.getVitaminizations());
        model.addAttribute("listObjects",           this.objectService.getObjectsAliveWithoutParents());
        model.addAttribute("listDrugs",             this.drugService.getVitamines());
        model.addAttribute("listTanks",             this.tankService.getTanks());

        return "vitaminization";
    }

}
