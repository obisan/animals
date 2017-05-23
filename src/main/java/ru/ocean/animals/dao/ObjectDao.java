package ru.ocean.animals.dao;

import ru.ocean.animals.model.Object;

import java.util.List;

public interface ObjectDao {
    void                addObject(Object object);
    void                updateObject(Object object);
    Object              getObjectById(long id);
    List<Object>        getObjectsAlive();
    List<Object>        getObjectsAliveWithoutParents();
    List<Object>        getObjectsAliveWithoutParents2LoginUser(long department_id);
    List<Object>        getObjectsAliveWithoutParentsBySpecie(long specie_id);
    List<Object>        getObjectsAliveWithoutParentsBySpecie2LoginUser(long specie_id, long department_id);
    List<Object>        getObjectsAliveWithoutParentsByTank(long tank_id);
    List<Object>        getObjectsAliveWithoutParentsByTankAndAquarium(long tank_id, long aquarium_id);
    List<Object>        getObjectsAliveWithoutParentsByEmployee(long employee_id);
    List<Object>        getObjectsAliveWithoutParentsByDepartment(long department_id);
    List<Object>        getObjectsWithDeads();
    List<Object>        getObjectsFilteredBySpecieId(long specie_id);
    void                removeObject(long id);
}
