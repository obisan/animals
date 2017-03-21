package ru.ocean.animals.service;

import ru.ocean.animals.model.Drug;
import ru.ocean.animals.model.Medication;
import ru.ocean.animals.model.MedicationExtended;

import java.util.List;

public interface MedicationService {
    void                addMedication(Medication medication, List<Drug> drugs);
    void                updateMedication(Medication medication, List<Drug> drugs);
    Medication          getMedicationById(long id);
    MedicationExtended  getMedicationExtendedById(long id);
    List<Medication>    getMedications();
    void                removeAllAssigmentByMedication(Medication medication);
    void                removeMedication(long id);
}
