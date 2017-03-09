package ru.ocean.animals.service;

import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.model.Displacement;
import ru.ocean.animals.model.Object;
import ru.ocean.animals.model.Quarantine;

import java.util.List;

public interface ObjectService {
    void                addObject(Object object);
    void                updateObject(Object object);
    List<Object>        splitObject2(Object parent, int count, long tank_target);
    Object              getObjectById(long id);
    List<Object>        getObjectsAlive();
    List<Object>        getObjectsAliveWithoutParents();
    List<Object>        getObjectsWithDeads();
    List<Object>        getObjectsFilteredBySpecieId(long specie_id);

    List<Quarantine>    getQuarantinesOfObject(long id);
    List<Deceased>      getDeceasedsOfObject(long id);
    List<Displacement>  getDisplacementsOfObject(long id);

    void                removeObject(long id);
}
