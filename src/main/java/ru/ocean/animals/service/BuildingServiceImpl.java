package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.BuildingDao;
import ru.ocean.animals.model.Building;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingDao buildingDao;

    @Transactional("dubinets")
    public void addBuilding(Building building) {
        this.buildingDao.addBuilding(building);
    }

    @Transactional("dubinets")
    public void updateBuilding(Building building) {
        this.buildingDao.updateBuilding(building);
    }

    @Transactional("dubinets")
    public Building getBuildingById(long id) {
        return this.buildingDao.getBuildingById(id);
    }

    @Transactional("dubinets")
    public List<Building> getBuildings() {
        return this.buildingDao.getBuildings();
    }

    @Transactional("dubinets")
    public void removeBuilding(long id) {
        this.buildingDao.getBuildings();
    }
}
