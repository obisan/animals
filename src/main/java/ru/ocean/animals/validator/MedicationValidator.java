package ru.ocean.animals.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ocean.animals.model.Medication;
import ru.ocean.animals.service.MedicationService;

@Component
public class MedicationValidator implements Validator {

    @Autowired
    private MedicationService medicationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Medication.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Medication medication = (Medication) o;

        if(medication.getMedication_start_date() == null) {
            errors.rejectValue("medication_start_date", "Null.value");
        }

        if(medication.getObject_id() == null) {
            errors.rejectValue("object_id", "Null.value");
        }

        if(medication.getDrug_id() == null) {
            errors.rejectValue("drug_id", "Null.value");
        }

    }
}
