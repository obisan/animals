package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Photo;
import ru.ocean.animals.service.PhotoService;

public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "photos", method = RequestMethod.GET)
    public String getPhotos(Model model) {
        model.addAttribute("photos",        new Photo());
        return "photo";
    }

    @RequestMapping(value = "/photos/add", method = RequestMethod.POST)
    public String addPhoto(@ModelAttribute("photo") Photo photo) {

        if(photo.getId() == null) {
            this.photoService.addPhoto(photo);
        } else {
            this.photoService.updatePhoto(photo);
        }
        return "redirect:/photos";
    }

    @RequestMapping(value = "/photo/remove/{id}")
    public String removePhoto(@PathVariable("id") long id) {
        this.photoService.removePhoto(id);

        return "redirect:/photos";
    }

    @RequestMapping(value = "/photo/edit/{id}")
    public String editPhoto(@PathVariable("id") long id, Model model) {
        model.addAttribute("photo",         this.photoService.getPhotoById(id));

        return "photo";
    }

}
