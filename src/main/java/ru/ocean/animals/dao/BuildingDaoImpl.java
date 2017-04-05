package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Building;

import java.util.List;

@Repository
public class BuildingDaoImpl implements BuildingDao {
    private static final Logger logger = LoggerFactory.getLogger(BuildingDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    public void addBuilding(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(building);
        logger.info("Building successfully added. Building details: " + building);
    }

    public void updateBuilding(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.update(building);
        logger.info("Building successfully updated. Building details: " + building);
    }

    public Building getBuildingById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Building building = (Building) session.load(Building.class, new Long(id));
        logger.info("Building successfully loaded. Building details: " + building);
        return building;
    }

    @SuppressWarnings("unchecked")
    public List<Building> getBuildings() {
        Session session = sessionFactory.getCurrentSession();

        List<Building> buildings = session.createQuery("from Building").list();
        logger.info("Building list successfully added. Building details: " + buildings);
        return buildings;
    }

    public void removeBuilding(long id) {
        Session session = sessionFactory.getCurrentSession();
        Building building = (Building) session.load(Building.class, new Long(id));

        if(building != null) {
            session.delete(building);
        }

        logger.info("Building successfully removed. Building details: " + building);
    }
}
