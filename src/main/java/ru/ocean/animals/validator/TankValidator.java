package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Tank;
import ru.ocean.animals.service.TankService;

@Component
public class TankValidator implements Validator {

    @Autowired
    private TankService tankService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Tank.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Tank tank = (Tank) o;

        if(tank.getTank_name().equals("")) {
            errors.rejectValue("tank_name", "Null.value");
        }

    }
}
