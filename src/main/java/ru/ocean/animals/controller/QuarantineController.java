package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Quarantine;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.service.QuarantineService;

@Controller
public class QuarantineController {

    @Autowired
    private QuarantineService   quarantineService;

    @Autowired
    private ObjectService       objectService;

    @RequestMapping(value = "/quarantines", method = RequestMethod.GET)
    public String getQuarantines(Model model) {
        model.addAttribute("quarantine",        new Quarantine());
        model.addAttribute("listQuarantines",   this.quarantineService.getQuarantines());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());

        return "quarantine";
    }

    @RequestMapping(value = "/quarantine/add", method = RequestMethod.POST)
    public String addQuarantine(@ModelAttribute("quarantine") Quarantine quarantine){
        if(quarantine.getId() == null) {
            this.quarantineService.addQuarantine(quarantine);
        } else {
            this.quarantineService.updateQuarantine(quarantine);
        }

        return "redirect:/quarantines";
    }

    @RequestMapping(value = "/quarantine/remove/{id}")
    public String removeQuarantine(@PathVariable("id") long id) {
        this.quarantineService.removeQuarantine(id);

        return "redirect:/quarantines";
    }

    @RequestMapping(value = "/quarantine/edit/{id}")
    public String editQuarantine(@PathVariable("id") long id, Model model) {
        model.addAttribute("quarantine",        this.quarantineService.getQuarantineById(id));
        model.addAttribute("listQuarantines",   this.quarantineService.getQuarantines());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());

        return "quarantine";
    }


}
