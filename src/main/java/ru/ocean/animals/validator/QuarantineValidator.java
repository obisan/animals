package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Quarantine;
import ru.ocean.animals.service.QuarantineService;

@Component
public class QuarantineValidator implements Validator {

    @Autowired
    private QuarantineService quarantineService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Quarantine.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Quarantine quarantine = (Quarantine) o;

        if(quarantine.getQuarantine_date_start() == null) {
            errors.rejectValue("quarantine_date_start", "Null.value");
        }

        if(quarantine.getObject_id() == null) {
            errors.rejectValue("object_id", "Null.value");
        }

    }
}
