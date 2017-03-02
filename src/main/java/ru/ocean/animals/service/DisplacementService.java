package ru.ocean.animals.service;

import ru.ocean.animals.model.Displacement;

import java.util.List;

public interface DisplacementService {
    void                        addDisplacement(Displacement displacement);
    void                        updateDisplacement(Displacement displacement);
    Displacement                getDisplacementById(long id);
    List<Displacement>          getDisplacements();
    void                        removeDisplacement(long id);
}
