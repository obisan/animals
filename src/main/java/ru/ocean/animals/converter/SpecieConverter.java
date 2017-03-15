package ru.ocean.animals.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.ocean.animals.model.Specie;
import ru.ocean.animals.service.SpecieService;

public class SpecieConverter implements Converter<String, Specie> {

    @Autowired
    private SpecieService specieService;

    @Override
    public Specie convert(String s) {

        specieService.getSpecieById(1);

        return null;
    }
}
