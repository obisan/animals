package ru.ocean.animals.service;

import ru.ocean.animals.model.Medication;

import java.util.List;

public interface MedicationService {
    void                addMedication(Medication medication);
    void                updateMedication(Medication medication);
    Medication          getMedicationById(long id);
    List<Medication>    getMedications();
    void                removeMedication(long id);
}
