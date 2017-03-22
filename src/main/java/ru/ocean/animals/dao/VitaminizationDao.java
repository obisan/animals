package ru.ocean.animals.dao;

import ru.ocean.animals.model.Vitaminization;

import java.util.List;

public interface VitaminizationDao {
    void                    addVitaminization(Vitaminization vitaminization);
    void                    updateVitaminization(Vitaminization vitaminization);
    Vitaminization          getVitaminizationById(long id);
    List<Vitaminization>    getVitaminizations();
    void                    removeVitaminization(long id);
}
