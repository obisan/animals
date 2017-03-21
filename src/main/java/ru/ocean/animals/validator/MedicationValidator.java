package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.MedicationExtended;
import ru.ocean.animals.service.MedicationService;

@Component
public class MedicationValidator implements Validator {

    @Autowired
    private MedicationService medicationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return MedicationExtended.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MedicationExtended medication = (MedicationExtended) o;

        if(medication.getMedication().getMedication_start_date() == null) {
            errors.rejectValue("medication.medication_start_date", "Null.value");
        }

        if(medication.getMedication().getObject_id() == null) {
            errors.rejectValue("medication.object_id", "Null.value");
        }
    }
}
