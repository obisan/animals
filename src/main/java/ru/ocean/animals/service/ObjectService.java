package ru.ocean.animals.service;

import ru.ocean.animals.model.Object;

import java.util.List;

public interface ObjectService {
    void            addObject(Object object);
    void            updateObject(Object object);
    Object          splitObject(long object_id, int count);
    Object          getObjectById(long id);
    List<Object>    getObjectsAlive();
    List<Object>    getObjectsWithDeads();
    List<Object>    getObjectsFilteredBySpecieId(long specie_id);
    void            removeObject(long id);
}
