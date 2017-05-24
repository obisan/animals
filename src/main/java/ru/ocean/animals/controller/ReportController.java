package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.model.DeceasedCriteria;
import ru.ocean.animals.service.DeceasedService;
import ru.ocean.animals.service.SpecieService;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private DeceasedService     deceasedService;

    @Autowired
    private SpecieService       specieService;

    List<Deceased> deceasedList;

    @RequestMapping(value = "/report/deads", method = RequestMethod.GET)
    public String getDeads(@ModelAttribute("deceasedCriteria") DeceasedCriteria deceasedCriteria, Model model) {
        model.addAttribute("listSpecies",       this.specieService.getSpecies());

        if(deceasedCriteria.getDate_from() != null || deceasedCriteria.getDate_to() != null || deceasedCriteria.getSpecie_id() != null) {
            this.deceasedList =  this.deceasedService.findDeceased(deceasedCriteria);
        } else {
            this.deceasedList = this.deceasedService.getDeceaseds();
        }

        model.addAttribute("listDeceaseds",     deceasedList);

        return "report/dead";
    }

    @RequestMapping(value = "/download/report/excel/deads", method = RequestMethod.GET)
    public ModelAndView excel(@ModelAttribute("deceasedCriteria") DeceasedCriteria deceasedCriteria) {
        return new ModelAndView("excelViewReportDeads", "deadData", deceasedList);
    }

}
