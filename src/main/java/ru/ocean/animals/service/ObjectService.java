package ru.ocean.animals.service;

import ru.ocean.animals.model.*;
import ru.ocean.animals.model.Object;

import java.util.List;

public interface ObjectService {
    void                addObject(Object object);
    void                addObjectExtended(ObjectExtended object);
    void                updateObject(Object object);
    void                updateObjectExtended(ObjectExtended object);
    List<Object>        splitObject2(Object parent, int count, long tank_target);
    Object              getObjectById(long id);
    ObjectExtended      getObjectExtendedById(long id);
    List<Object>        getObjectsAlive();
    List<Object>        getObjectsAliveWithoutParents();
    List<Object>        getObjectsAliveWithoutParentsBySpecie(long specie_id);
    List<Object>        getObjectsAliveWithoutParentsByTank(long tank_id);
    List<Object>        getObjectsAliveWithoutParentsByEmployee(long employee_id);
    List<Object>        getObjectsAliveWithoutParentsByDepartment(long department_id);
    List<Object>        getObjectsWithDeads();
    List<Object>        getObjectsFilteredBySpecieId(long specie_id);
    List<Quarantine>    getQuarantinesOfObject(long id);
    List<Deceased>      getDeceasedsOfObject(long id);
    List<Displacement>  getDisplacementsOfObject(long id);

    void                removeObject(long id);
}
