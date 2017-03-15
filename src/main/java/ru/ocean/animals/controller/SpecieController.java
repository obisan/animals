package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ocean.animals.model.Photo;
import ru.ocean.animals.model.Specie;
import ru.ocean.animals.service.ObjectService;
import ru.ocean.animals.service.SpecieService;
import ru.ocean.animals.service.TagService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Controller
public class SpecieController {

    @Autowired
    private ObjectService   objectService;

    @Autowired
    private SpecieService   specieService;

    @Autowired
    private TagService      tagService;

    @RequestMapping(value = "/species", method = RequestMethod.GET)
    public String getSpecie(Model model) {
        model.addAttribute("specie",        new Specie());
        model.addAttribute("listSpecies",   this.specieService.getSpecies());
        model.addAttribute("listTags",      this.tagService.getTags());

        return "specie";
    }

    @RequestMapping(value = "/specie/add", method = RequestMethod.POST)
    public String addSpecie(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3") MultipartFile file3,
            @ModelAttribute("specie") Specie specie) {
        if(specie.getId() == null) {
            this.specieService.addSpecie(specie);

            Photo photo1 = save_file(file1, specie.getId(), 1);
            Photo photo2 = save_file(file2, specie.getId(), 2);
            Photo photo3 = save_file(file3, specie.getId(), 3);

            specie.getPhotos().add(photo1);
            specie.getPhotos().add(photo2);
            specie.getPhotos().add(photo3);
        } else {
            this.specieService.updateSpecie(specie);
        }

        this.specieService.updateSpecie(specie);

        return "redirect:/species";
    }

    @RequestMapping(value = "/specie/remove/{id}")
    public String removeSpecie(@PathVariable("id") long id) {
        this.specieService.removeSpecie(id);

        return "redirect:/species";
    }


    @RequestMapping(value = "/specie/edit/{id}")
    public String editSpecie(@PathVariable("id") long id, Model model) {
        model.addAttribute("specie",        this.specieService.getSpecieById(id));
        model.addAttribute("listSpecies",   this.specieService.getSpecies());
        //model.addAttribute("listTags",      this.specieService.getSpecieById(id).getTags2());
        model.addAttribute("listTags",      this.tagService.getTags());

        return "specie";
    }

    @RequestMapping(value = "/specie/info/{id}")
    public String infoSpecie(@PathVariable("id") long id, Model model) {
        model.addAttribute("specie",        this.specieService.getSpecieById(id));
        model.addAttribute("listObjects",   this.objectService.getObjectsAliveWithoutParentsBySpecie(id));

        return "/info/specie";
    }

    private Photo save_file(MultipartFile file, long id, long num) {
        Photo photo = null;
        String path;
        try {
            if (!file.isEmpty()) {
                path = System.getenv("CATALINA_HOME") + "/uploads/specie_" + id + "_" + num + ".png";
                //path = "C:\\Downloads\\" + "specie_" + id + "_" + num + ".png";

                photo = new Photo();
                photo.setPhoto_link(path);
                photo.setSpecie_id(id);

                ImageIO.setUseCache(false);
                BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));

                File destination = new File(path);
                ImageIO.write(src, "png", destination);
                //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return photo;
    }
}
