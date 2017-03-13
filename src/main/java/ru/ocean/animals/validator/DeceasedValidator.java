package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.service.DeceasedService;

@Component
public class DeceasedValidator implements Validator {

    @Autowired
    private DeceasedService deceasedService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Deceased.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Deceased deceased = (Deceased) o;

        if(deceased.getDeceased_date()== null) {
            errors.rejectValue( "deceased_date", "Null.value");
        }

        if(deceased.getDeceased_count() == null) {
            errors.rejectValue("deceased_count", "Null.value");
        }

        if(deceased.getObject_id() == null) {
            errors.rejectValue("object_id", "Null.value");
        }
    }
}
