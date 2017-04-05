package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Tank;
import ru.ocean.animals.service.TankService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        if(tank.getTank_number().equals("")) {
            errors.rejectValue("tank_number", "Null.value");
        } else {
            Pattern pattern = Pattern.compile(
                    "[а-яА-ЯёЁ]+"
            );
            Matcher matcher = pattern.matcher(tank.getTank_number());

            if(matcher.matches()) {
                errors.rejectValue("tank_number", "Russian.value");
            }
        }

        if(tank.getTank_volume() == null) {
            errors.rejectValue("tank_volume", "Null.value");
        }

    }
}
