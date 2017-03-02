package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Displacement;
import ru.ocean.animals.model.Object;
import ru.ocean.animals.service.DisplacementService;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.service.TankService;

@Controller
public class DisplacementController {

    @Autowired
    private DisplacementService     displacementService;

    @Autowired
    private ObjectService           objectService;

    @Autowired
    private TankService             tankService;

    @RequestMapping(value = "/displacements", method = RequestMethod.GET)
    public String getDisplacements(Model model) {
        model.addAttribute("displacement",          new Displacement());
        model.addAttribute("listDisplacements",     this.displacementService.getDisplacements());
        model.addAttribute("listObjects",           this.objectService.getObjectsAlive());
        model.addAttribute("listTanks",             this.tankService.getTanks());

        return "displacement";
    }

    @RequestMapping(value = "/displacement/add", method = RequestMethod.POST)
    public String addDisplacement(@ModelAttribute("displacement") Displacement displacement) {
        Object object = this.objectService.getObjectById(displacement.getObject_id());
        if(displacement.getDisplacement_count() < object.getObject_count()) {
            Object object2 = this.objectService.splitObject(object.getId(), displacement.getDisplacement_count());
            object2.setTank_id(displacement.getTank_id());
            this.objectService.updateObject(object2);
        } else {
            object.setTank_id(displacement.getTank_id());
            this.objectService.updateObject(object);
        }

        if(displacement.getId() == null) {
            this.displacementService.addDisplacement(displacement);
        } else {
            this.displacementService.updateDisplacement(displacement);
        }

        return "redirect:/displacements";
    }

    @RequestMapping(value = "/displacement/remove/{id}")
    public String removeDisplacement(@PathVariable("id") long id) {
        this.displacementService.removeDisplacement(id);

        return "redirect:/displacements";
    }

    @RequestMapping(value = "/displacement/edit/{id}")
    public String editDisplacement(@PathVariable("id") long id, Model model) {
        model.addAttribute("displacement",          this.displacementService.getDisplacementById(id));
        model.addAttribute("listDisplacements",     this.displacementService.getDisplacements());
        model.addAttribute("listObjects",           this.objectService.getObjectsAlive());
        model.addAttribute("listTanks",             this.tankService.getTanks());

        return "displacement";
    }

}
