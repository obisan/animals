package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Drug;
import ru.ocean.animals.model.MedicationExtended;
import ru.ocean.animals.service.DrugService;
import ru.ocean.animals.service.MedicationService;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.validator.MedicationValidator;

import java.util.ArrayList;

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
        model.addAttribute("medication",        new MedicationExtended());
        model.addAttribute("drug1",             new Drug());
        model.addAttribute("drug2",             new Drug());
        model.addAttribute("drug3",             new Drug());
        model.addAttribute("drug4",             new Drug());
        model.addAttribute("listMedications",   this.medicationService.getMedications());
        model.addAttribute("listObjects",       this.objectService.getObjectsAliveWithoutParents());
        model.addAttribute("listDrugs",         this.drugService.getMedicament());

        return "medication";
    }

    @RequestMapping(value = "/medication/add", method = RequestMethod.POST)
    public String addMedication(@ModelAttribute("medication") MedicationExtended medication, BindingResult bindingResult, Model model) {
        medicationValidator.validate(medication, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("listMedications",   this.medicationService.getMedications());
            model.addAttribute("listObjects",       this.objectService.getObjectsAliveWithoutParents());
            model.addAttribute("listDrugs",         this.drugService.getMedicament());

            return "medication";
        }

        ArrayList<Drug> drugs = new ArrayList<>();
        drugs.add(medication.getDrug1());
        drugs.add(medication.getDrug2());
        drugs.add(medication.getDrug3());
        drugs.add(medication.getDrug4());

        if(medication.getMedication().getId() == null) {
            this.medicationService.addMedication(medication.getMedication(), drugs);
        } else {
            this.medicationService.removeMedication(medication.getMedication().getId());
            medication.getMedication().setId(null);
            this.medicationService.addMedication(medication.getMedication(), drugs);
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
        model.addAttribute("medication",        this.medicationService.getMedicationExtendedById(id));
        model.addAttribute("listMedications",   this.medicationService.getMedications());
        model.addAttribute("listObjects",       this.objectService.getObjectsAliveWithoutParents());
        model.addAttribute("listDrugs",         this.drugService.getMedicament());

        return "medication";
    }

}
