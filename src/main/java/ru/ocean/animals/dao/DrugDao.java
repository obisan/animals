package ru.ocean.animals.dao;

import ru.ocean.animals.model.Drug;

import java.util.List;

public interface DrugDao {
    void        addDrug(Drug drug);
    void        updateDrug(Drug drug);
    Drug        getDrugById(long id);
    List<Drug>  getDrugs();
    void        removeDrug(long id);
}
