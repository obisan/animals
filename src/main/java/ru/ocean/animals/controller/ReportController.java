package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.DeceasedCriteria;
import ru.ocean.animals.service.DeceasedService;
import ru.ocean.animals.service.SpecieService;

@Controller
public class ReportController {

    @Autowired
    private DeceasedService     deceasedService;

    @Autowired
    private SpecieService       specieService;

    @RequestMapping(value = "/report/deads", method = RequestMethod.GET)
    public String getDeads(
            @ModelAttribute("deceasedCriteria") DeceasedCriteria deceasedCriteria,
            Model model) {
        model.addAttribute("listSpecies",       this.specieService.getSpecies());

        if(deceasedCriteria.getDate_from() != null) {
            model.addAttribute("listDeceaseds",     this.deceasedService.findDeceased(deceasedCriteria));
        } else {
            model.addAttribute("listDeceaseds",     this.deceasedService.getDeceaseds());
        }

        return "report/dead";
    }

}
