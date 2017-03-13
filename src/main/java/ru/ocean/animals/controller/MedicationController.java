package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Medication;
import ru.ocean.animals.service.DrugService;
import ru.ocean.animals.service.MedicationService;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.validator.MedicationValidator;

@Controller
public class MedicationController {

    @Autowired
    private MedicationService   medicationService;

    @Autowired
    private DrugService         drugService;

    @Autowired
    private ObjectService       objectService;

    @Autowired
    private MedicationValidator medicationValidator;

    @RequestMapping(value = "/medications", method = RequestMethod.GET)
    public String getMedications(Model model) {
        model.addAttribute("medication",        new Medication());
        model.addAttribute("listMedications",   this.medicationService.getMedications());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());
        model.addAttribute("listDrugs",         this.drugService.getDrugs());

        return "medication";
    }

    @RequestMapping(value = "/medication/add", method = RequestMethod.POST)
    public String addMedication(@ModelAttribute("medication") Medication medication, BindingResult bindingResult, Model model) {
        medicationValidator.validate(medication, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("listMedications",   this.medicationService.getMedications());
            model.addAttribute("listObjects",       this.objectService.getObjectsAlive());
            model.addAttribute("listDrugs",         this.drugService.getDrugs());

            return "medication";
        }

        if(medication.getId() == null) {
            this.medicationService.addMedication(medication);
        } else {
            this.medicationService.updateMedication(medication);
        }

        return "redirect:/medications";
    }

    @RequestMapping(value = "/medication/remove/{id}")
    public String removeMedication(@PathVariable("id") long id) {
        this.medicationService.removeMedication(id);

        return "redirect:/medications";
    }

    @RequestMapping(value = "/medication/edit/{id}")
    public String editMedication(@PathVariable("id") long id, Model model) {
        model.addAttribute("medication",        this.medicationService.getMedicationById(id));
        model.addAttribute("listMedications",   this.medicationService.getMedications());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());
        model.addAttribute("listDrugs",         this.drugService.getDrugs());

        return "medication";
    }

}
