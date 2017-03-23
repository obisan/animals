package ru.ocean.animals.service;

import ru.ocean.animals.model.Drug;

import java.util.List;

public interface DrugService {
    void        addDrug(Drug drug);
    void        updateDrug(Drug drug);
    Drug        getDrugById(long id);
    List<Drug>  getDrugs();
    List<Drug>  getVitamines();
    List<Drug>  getMedicament();
    void        removeDrug(long id);
}
