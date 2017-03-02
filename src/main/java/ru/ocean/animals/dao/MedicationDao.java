package ru.ocean.animals.dao;

import ru.ocean.animals.model.Medication;

import java.util.List;

public interface MedicationDao {
    void                addMedication(Medication medication);
    void                updateMedication(Medication medication);
    Medication          getMedicationById(long id);
    List<Medication>    getMedications();
    void                removeMedication(long id);
}
