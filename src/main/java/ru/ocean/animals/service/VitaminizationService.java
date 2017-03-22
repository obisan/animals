package ru.ocean.animals.service;

import ru.ocean.animals.model.Drug;
import ru.ocean.animals.model.Vitaminization;
import ru.ocean.animals.model.VitaminizationExtended;

import java.util.List;

public interface VitaminizationService {
    void                    addVitaminization(Vitaminization vitaminization, List<Drug> drugs);
    void                    updateVitaminization(Vitaminization vitaminization, List<Drug> drugs);
    Vitaminization          getVitaminizationById(long id);
    VitaminizationExtended  getVitaminizationExtendedById(long id);
    List<Vitaminization>    getVitaminizations();
    void                    removeVitaminization(long id);
}
