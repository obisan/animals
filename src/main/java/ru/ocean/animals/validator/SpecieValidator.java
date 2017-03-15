package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Specie;
import ru.ocean.animals.service.SpecieService;

@Component
public class SpecieValidator implements Validator {

    @Autowired
    private SpecieService specieService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Specie.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Specie specie = (Specie) o;

        if(specie.getSpecie_name_lat().equals("")) {
            errors.rejectValue("specie_name_lat", "Null.value");
        }

        if(specie.getSpecie_name_ru().equals("")) {
            errors.rejectValue("specie_name_ru", "Null.value");
        }

    }
}
