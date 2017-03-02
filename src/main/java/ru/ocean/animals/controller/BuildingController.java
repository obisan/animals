package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Building;
import ru.ocean.animals.service.BuildingService;

@Controller
public class BuildingController {

    @Autowired
    private BuildingService         buildingService;

    @RequestMapping(value = "/buildings", method = RequestMethod.GET)
    public String getBuildings(Model model) {
        model.addAttribute("building",          new Building());
        model.addAttribute("listBuildings",     this.buildingService.getBuildings());

        return "building";
    }

    @RequestMapping(value = "/building/add", method = RequestMethod.POST)
    public String addBuilding(@ModelAttribute("building") Building building) {
        if(building.getId() == null) {
            this.buildingService.addBuilding(building);
        } else {
            this.buildingService.updateBuilding(building);
        }

        return "redirect:/buildings";
    }

    @RequestMapping(value = "/building/remove/{id}")
    public String removeBuilding(@PathVariable("id") long id) {
        this.buildingService.removeBuilding(id);

        return "redirect:/buildings";
    }

    @RequestMapping(value = "/building/edit/{id}")
    public String editBuilding(@PathVariable("id") long id, Model model) {
        model.addAttribute("building",      this.buildingService.getBuildingById(id));
        model.addAttribute("listBuildings",  this.buildingService.getBuildings());

        return "building";
    }


}
