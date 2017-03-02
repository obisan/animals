package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Family;
import ru.ocean.animals.service.FamilyService;
import ru.ocean.animals.service.OrderService;

@Controller
public class FamilyController {

    @Autowired
    private FamilyService   familyService;

    @Autowired
    private OrderService    orderService;

    @RequestMapping(value = "/families", method = RequestMethod.GET)
    public String getFamilies(Model model) {
        model.addAttribute("family", new Family());
        model.addAttribute("listFamilies",  this.familyService.getFamilies());
        model.addAttribute("listOrders",    this.orderService.getOrders());

        return "family";
    }

    @RequestMapping(value = "/family/add", method = RequestMethod.POST)
    public String addFamily(@ModelAttribute("family") Family family) {
        if(family.getId() == null) {
            this.familyService.addFamily(family);
        } else {
            this.familyService.updateFamily(family);
        }

        return "redirect:/families";
    }

    @RequestMapping(value = "/family/remove/{id}")
    public String removeFamily(@PathVariable("id") long id) {
        this.familyService.removeFamily(id);

        return "redirect:/families";
    }

    @RequestMapping(value = "/family/edit/{id}")
    public String editFamily(@PathVariable("id") long id, Model model) {
        model.addAttribute("family",        this.familyService.getFamilyById(id));
        model.addAttribute("listFamilies",  this.familyService.getFamilies());
        model.addAttribute("listOrders",    this.orderService.getOrders());

        return "family";
    }




}
