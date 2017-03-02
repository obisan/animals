package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Tag;
import ru.ocean.animals.service.TagService;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public String getTags(Model model) {
        model.addAttribute("tag", new Tag());
        model.addAttribute("listTags", this.tagService.getTags());

        return "tag";
    }

    @RequestMapping(value = "/tag/add", method = RequestMethod.POST)
    public String addTag(@ModelAttribute("tag") Tag tag) {
        if(tag.getId() == null) {
            this.tagService.addTag(tag);
        } else {
            this.tagService.updateTag(tag);
        }

        return "redirect:/tags";
    }

    @RequestMapping(value = "/tag/remove/{id}")
    public String removeTag(@PathVariable("id") long id) {
        this.tagService.removeTag(id);

        return "redirect:/tags";
    }

    @RequestMapping(value = "/tag/edit/{id}")
    public String editTag(@PathVariable("id") long id, Model model) {
        model.addAttribute("tag", this.tagService.getTagById(id));
        model.addAttribute("listTags", this.tagService.getTags());

        return "tag";
    }
}
