package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Drug;

import java.util.List;

@Repository
public class DrugDaoImpl implements DrugDao {
    private static final Logger logger = LoggerFactory.getLogger(DrugDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDrug(Drug drug) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(drug);
        logger.info("Drug successfully added. Drug details: " + drug);
    }

    @Override
    public void updateDrug(Drug drug) {
        Session session = sessionFactory.getCurrentSession();
        session.update(drug);
        logger.info("Drug successfully updated. Drug details: " + drug);
    }

    @Override
    public Drug getDrugById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Drug drug = (Drug) session.load(Drug.class, new Long(id));
        logger.info("Drug successfully loaded. Drug details: " + drug);
        return drug;
    }

    @SuppressWarnings("unchecked")
    public List<Drug> getDrugs() {
        Session session = sessionFactory.getCurrentSession();
        List<Drug> drugs = session.createQuery("from Drug").list();
        logger.info("Drug list successfully loaded. Drug details: " + drugs);
        return drugs;
    }

    @SuppressWarnings("unchecked")
    public List<Drug> getVitamines() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Drug>) session.createSQLQuery(
                "CALL getVitamines()")
                .addEntity(Drug.class)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Drug> getMedicaments() {
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery(
                "CALL getMedicament()")
                .addEntity(Drug.class)
                .list();
    }

    @Override
    public void removeDrug(long id) {
        Session session = sessionFactory.getCurrentSession();

        Drug drug = (Drug) session.load(Drug.class, new Long(id));
        if(drug != null) {
            session.delete(drug);
        }
        logger.info("Drug successfully removed. Drug details: " + drug);
    }
}
