package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Object;
import ru.ocean.animals.model.ObjectExtended;
import ru.ocean.animals.service.ObjectService;

@Component
public class ObjectValidator implements Validator {

    @Autowired
    private ObjectService objectService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Object.class.equals(aClass);
    }

    @Override
    public void validate(java.lang.Object o, Errors errors) {
        ObjectExtended object = (ObjectExtended) o;

        if(object.getObject().getObject_name().equals("")) {
            errors.rejectValue("object.object_name", "Null.value");
        }

        if(object.getObject().getObject_count() == null) {
            errors.rejectValue("object.object_count", "Null.value");
        }

        if(object.getObject().getSpecie_id() == null) {
            errors.rejectValue( "object.specie_id", "Null.value");
        }

        if(object.getObject().getDepartment_id() == null) {
            errors.rejectValue("object.department_id", "Null.value");
        }

        if(object.getObject().getTank_id() == null) {
            errors.rejectValue("object.tank_id", "Null.value");
        }
    }
}
