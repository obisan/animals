package ru.ocean.animals.dao;

import ru.ocean.animals.model.Displacement;

import java.util.List;

public interface DisplacementDao {
    void                addDisplacement(Displacement displacement);
    void                updateDisplacement(Displacement displacement);
    Displacement        getDisplacementById(long id);
    List<Displacement>  getDisplacementOfObject(long animal_id);
    List<Displacement>  getDisplacements();
    void                removeDisplacement(long id);
}
