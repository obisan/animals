package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Allowance;
import ru.ocean.animals.model.Tank;
import ru.ocean.animals.service.BuildingService;
import ru.ocean.animals.service.EmployeeService;
import ru.ocean.animals.service.TankService;

@Controller
public class TankController {

    @Autowired
    private TankService         tankService;

    @Autowired
    private BuildingService     buildingService;

    @Autowired
    private EmployeeService     employeeService;

    @RequestMapping(value = "/tanks", method = RequestMethod.GET)
    public String getTanks(Model model) {
        model.addAttribute("tank",              new Tank());
        model.addAttribute("listTanks",         this.tankService.getTanks());
        model.addAttribute("listEmployees",     this.employeeService.getEmployees());
        model.addAttribute("listBuildings",     this.buildingService.getBuildings());

        return "tank";
    }

    @RequestMapping(value = "/tank/add", method = RequestMethod.POST)
    public String addTank(@ModelAttribute("tank") Tank tank) {
        if(tank.getId() == null) {
            this.tankService.addTank(tank);
        } else {
            this.tankService.updateTank(tank);
        }

        return "redirect:/tanks";
    }

    @RequestMapping(value = "/tank/remove/{id}")
    public String removeTank(@PathVariable("id") long id) {
        this.tankService.removeTank(id);

        return "redirect:/tanks";
    }

    @RequestMapping(value = "/tank/edit/{id}")
    public String editTank(@PathVariable("id") long id, Model model) {
        model.addAttribute("tank",              this.tankService.getTankById(id));
        model.addAttribute("listTanks",         this.tankService.getTanks());
        model.addAttribute("listEmployees",     this.employeeService.getEmployees());
        model.addAttribute("listBuildings",     this.buildingService.getBuildings());

        return "tank";
    }

    @RequestMapping(value = "/tank/info/{id}")
    public String infoTank(@PathVariable("id") long id, Model model) {
        model.addAttribute("tank",      this.tankService.getTankById(id));
        model.addAttribute("allowance", new Allowance());

        return "info/tank";
    }

}
