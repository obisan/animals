package ru.ocean.animals.dao;

import ru.ocean.animals.model.Object;
import java.util.List;

public interface ObjectDao {
    void                addObject(Object object);
    void                updateObject(Object object);
    Object              getObjectById(long id);
    List<Object>        getObjectsAlive();
    List<Object>        getObjectsAliveWithoutParents();
    List<Object>        getObjectsWithDeads();
    List<Object>        getObjectsFilteredBySpecieId(long specie_id);
    void                removeObject(long id);
}
