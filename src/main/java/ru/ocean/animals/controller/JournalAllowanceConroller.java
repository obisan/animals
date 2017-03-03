package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.JournalAllowanceExtended;
import ru.ocean.animals.service.AllowanceService;
import ru.ocean.animals.service.JournalAllowanceService;
import ru.ocean.animals.service.ObjectService;

@Controller
public class JournalAllowanceConroller {

    @Autowired
    private JournalAllowanceService journalAllowanceService;

    @Autowired
    private AllowanceService        allowanceService;

    @Autowired
    private ObjectService           objectService;

    @RequestMapping(value = "/journalallowances", method = RequestMethod.GET)
    public String getJournalAllowances(Model model) {
        model.addAttribute("journalAllowanceExtended",      new JournalAllowanceExtended());
        model.addAttribute("listJournalAllowances",         this.journalAllowanceService.getJournalAllowances());
        model.addAttribute("listAllowances",                this.allowanceService.getAllowances());
        model.addAttribute("listObjects",                   this.objectService.getObjectsAlive());

        return "journalallowance";
    }

    @RequestMapping(value = "/journalallowance/add")
    public String addJournalAllowance(
            @ModelAttribute("journalAllowanceExtended") JournalAllowanceExtended journalAllowanceExtended) {
        this.journalAllowanceService.addJournalAllowanceGroup(journalAllowanceExtended);

        return "redirect:/journalallowances";
    }

    @RequestMapping(value = "/journalallowance/remove/{id}")
    public String removeJournalAllowance(@PathVariable("id") long id) {
        this.journalAllowanceService.removeJournalAllowance(id);

        return "redirect:/journalallowances";
    }

    @RequestMapping(value = "/journalallowance/edit/{id}")
    public String editJournalAllowance(@PathVariable("id") long id, Model model) {
        model.addAttribute("journalallowance",      this.journalAllowanceService.getJournalAllowanceById(id));
        model.addAttribute("listJournalAllowances", this.journalAllowanceService.getJournalAllowances());
        model.addAttribute("listAllowances",        this.allowanceService.getAllowances());
        model.addAttribute("listObjects",           this.objectService.getObjectsAlive());

        return "journalallowance";
    }
}
