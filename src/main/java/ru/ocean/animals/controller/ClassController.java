package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Class;
import ru.ocean.animals.service.ClassService;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public String getClasses(Model model) {
        model.addAttribute("aclass", new Class());
        model.addAttribute("listClasses",  this.classService.getClasses());

        return "class";
    }

    @RequestMapping(value = "/class/add", method = RequestMethod.POST)
    public String addClass(@ModelAttribute("class") Class aclass) {

        if(aclass.getId() == null) {
            this.classService.addClass(aclass);
        } else {
            this.classService.updateClass(aclass);
        }

        return "redirect:/classes";
    }

    @RequestMapping(value = "/class/remove/{id}")
    public String removeClass(@PathVariable("id") long id){
        this.classService.removeClass(id);

        return "redirect:/classes";
    }

    @RequestMapping(value = "/class/edit/{id}")
    public String editPhylum(@PathVariable("id") long id, Model model) {
        model.addAttribute("class",         this.classService.getClassById(id));
        model.addAttribute("listClasses",   this.classService.getClasses());

        return "class";
    }
}
