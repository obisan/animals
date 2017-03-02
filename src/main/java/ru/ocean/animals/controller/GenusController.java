package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Genus;
import ru.ocean.animals.service.FamilyService;
import ru.ocean.animals.service.GenusService;

@Controller
public class GenusController {

    @Autowired
    private GenusService    genusService;

    @Autowired
    private FamilyService   familyService;

    @RequestMapping(value = "/genera", method = RequestMethod.GET)
    public String getGenera(Model model) {
        model.addAttribute("genus",         new Genus());
        model.addAttribute("listGenera",    this.genusService.getGenuses());
        model.addAttribute("listFamilies",  this.familyService.getFamilies());

        return "genus";
    }

    @RequestMapping(value = "/genus/add", method = RequestMethod.POST)
    public String addGenus(@ModelAttribute("genus") Genus genus) {
        if(genus.getId() == null) {
            this.genusService.addGenus(genus);
        } else {
            this.genusService.updateGenus(genus);
        }

        return "redirect:/genera";
    }

    @RequestMapping(value = "/genus/remove/{id}")
    public String removeGenus(@PathVariable("id") long id) {
        this.genusService.removeGenus(id);

        return "redirect:/genera";
    }

    @RequestMapping(value = "/genus/edit/{id}")
    public String editGenus(@PathVariable("id") long id, Model model) {
        model.addAttribute("genus",         this.genusService.getGenusById(id));
        model.addAttribute("listGenera",    this.genusService.getGenuses());
        model.addAttribute("listFamilies",  this.familyService.getFamilies());

        return "genus";
    }


}
