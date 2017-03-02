package ru.ocean.animals.dao;

import ru.ocean.animals.model.Building;

import java.util.List;

public interface BuildingDao {
    void            addBuilding(Building building);
    void            updateBuilding(Building building);
    Building        getBuildingById(long id);
    List<Building>  getBuildings();
    void            removeBuilding(long id);
}
