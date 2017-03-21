package ru.ocean.animals.dao;

import ru.ocean.animals.model.MedicationDrugs;

import java.util.List;

public interface MedicationDrugsDao {
    void                    addMedicationDrugs(MedicationDrugs medicationDrugs);
    void                    updateMedicationDrugs(MedicationDrugs medicationDrugs);
    MedicationDrugs         getMedicationDrugsById(long id);
    List<MedicationDrugs>   getMedicationDrugs();
    void                    removeMedicationDrugs(long id);
}
