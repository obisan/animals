package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Vitaminization;

import java.util.List;

@Repository
public class VitaminizationDaoImpl implements VitaminizationDao {
    private static final Logger logger = LoggerFactory.getLogger(VitaminizationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addVitaminization(Vitaminization vitaminization) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(vitaminization);
        logger.info("Vitaminization successfully added. Vitaminization details: " + vitaminization);
    }

    @Override
    public void updateVitaminization(Vitaminization vitaminization) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vitaminization);
        logger.info("Vitaminization successfully updated. Vitaminization details: " + vitaminization);
    }

    @Override
    public Vitaminization getVitaminizationById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Vitaminization vitaminization = (Vitaminization) session.load(Vitaminization.class, new Long(id));
        logger.info("Vitaminization successfully loaded. Vitaminization details: " + vitaminization);
        return vitaminization;
    }

    @SuppressWarnings("unchecked")
    public List<Vitaminization> getVitaminizations() {
        Session session = sessionFactory.getCurrentSession();
        List<Vitaminization> vitaminizations = session.createQuery("from Vitaminization").list();
        logger.info("Vitaminizations list successfully loaded. Vitaminization details: " + vitaminizations);
        return vitaminizations;
    }

    @Override
    public void removeVitaminization(long id) {
        Session session = sessionFactory.getCurrentSession();

        Vitaminization vitaminization = (Vitaminization) session.load(Vitaminization.class, new Long(id));
        if(vitaminization != null) {
            session.delete(vitaminization);
        }
        logger.info("Vitaminization successfully removed. Vitaminization details: " + vitaminization);
    }
}