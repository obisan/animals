package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Displacement;
import ru.ocean.animals.service.DisplacementService;

@Component
public class DisplacementValidator implements Validator {

    @Autowired
    private DisplacementService displacementService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Displacement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Displacement displacement = (Displacement) o;

        if(displacement.getDate_arrival() == null) {
            errors.rejectValue("date_arrival", "Null.value");
        }

        if(displacement.getDisplacement_count() == null) {
            errors.rejectValue("displacement_count", "Null.value");
        }

        if(displacement.getObject_id() == null) {
            errors.rejectValue("object_id", "Null.value");
        }

        if(displacement.getTank_id() == null) {
            errors.rejectValue("tank_id", "Null.value");
        }

    }
}
