package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Specie;

import java.util.List;

@Repository
public class SpecieDaoImpl implements SpecieDao {
    private static final Logger logger = LoggerFactory.getLogger(SpecieDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addSpecie(Specie specie) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(specie);
        logger.info("Specie successfully added. Specie details: " + specie);
    }

    public void updateSpecie(Specie specie) {
        Session session = sessionFactory.getCurrentSession();
        session.update(specie);
        logger.info("Specie successfully updated. Specie details: " + specie);
    }

    public Specie getSpecieById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Specie specie = (Specie) session.load(Specie.class, new Long(id));
        logger.info("Specie successfully loaded. Specie details: " + specie);

        return specie;
    }

    @SuppressWarnings("unchecked")
    public List<Specie> getSpecies() {
        Session session = sessionFactory.getCurrentSession();

        List<Specie> species = session.createQuery("from Specie").list();
        logger.info("Specie list successfully loaded. Specie details: " + species);
        return species;
    }

    public void removeSpecie(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Specie specie = (Specie) session.load(Specie.class, new Long(id));

        if(specie != null) {
            session.delete(specie);
        }

        logger.info("Specie successfully removed. Specie details: " + specie);
    }
}
