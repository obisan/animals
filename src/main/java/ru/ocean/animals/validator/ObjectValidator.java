package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Object;
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
        Object object = (Object) o;

        if(object.getObject_name() == null) {
            errors.rejectValue("object_name", "Null.value");
        }

        if(object.getObject_count() == null) {
            errors.rejectValue("object_count", "Null.value");
        }

        if(object.getSpecie_id() == null) {
            errors.rejectValue( "specie_id", "Null.value");
        }

        if(object.getEmployee_id() == null) {
            errors.rejectValue("employee_id", "Null.value");
        }

        if(object.getTank_id() == null) {
            errors.rejectValue("tank_id", "Null.value");
        }
    }
}
