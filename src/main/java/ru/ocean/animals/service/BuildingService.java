package ru.ocean.animals.service;

import ru.ocean.animals.model.Building;

import java.util.List;

public interface BuildingService {
    void                addBuilding(Building building);
    void                updateBuilding(Building building);
    Building            getBuildingById(long id);
    List<Building>      getBuildings();
    void                removeBuilding(long id);
}
