package ru.ocean.animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        String path = System.getenv("CATALINA_HOME") + "/uploads/specie_" + imageName + "_" + 1 + ".png";

        File serverFile = new File(path);

        return Files.readAllBytes(serverFile.toPath());
    }

}
