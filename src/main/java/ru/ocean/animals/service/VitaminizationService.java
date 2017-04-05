package ru.ocean.animals.service;

import ru.ocean.animals.model.Vitaminization;
import ru.ocean.animals.model.VitaminizationExtended;

import java.util.List;

public interface VitaminizationService {
    void                    addVitaminization(VitaminizationExtended vitaminization);
    void                    updateVitaminization(VitaminizationExtended vitaminization);
    Vitaminization          getVitaminizationById(long id);
    VitaminizationExtended  getVitaminizationExtendedById(long id);
    List<Vitaminization>    getVitaminizations();
    void                    removeVitaminization(long id);
}
