package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.model.DeceasedCriteria;

import java.util.List;

@Repository
public class DeceasedDaoImpl implements DeceasedDao {
    private static final Logger logger = LoggerFactory.getLogger(DisplacementDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addDeceased(Deceased deceased) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(deceased);
        logger.info("Deceased successfully added. Deceased details: " + deceased);
    }

    public void updateDeceased(Deceased deceased) {
        Session session = sessionFactory.getCurrentSession();
        session.update(deceased);
        logger.info("Deceased successfully updated. Deceased details: " + deceased);
    }

    public Deceased getDeceasedById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Deceased deceased = (Deceased) session.load(Deceased.class, new Long(id));
        logger.info("Deceased successfully loaded. Deceased details: " + deceased);
        return deceased;
    }

    @SuppressWarnings("unchecked")
    public List<Deceased> getDeceaseds() {
        Session session = sessionFactory.getCurrentSession();

        List<Deceased> deceaseds = session.createQuery("from Deceased").list();
        for(Deceased deceased : deceaseds) {
            logger.info("Deceased successfully loaded. Deceased details: " + deceased);
        }
        return deceaseds;
    }

    public void removeDeceased(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Deceased deceased = (Deceased) session.load(Deceased.class, new Long(id));
        if(deceased != null) {
            session.delete(deceased);
        }
        logger.info("Deceased successfully removed. Deceased details: " + deceased);
    }

    @SuppressWarnings("unchecked")
    public List<Deceased> findDeceased(DeceasedCriteria deceasedCriteria) {
        Session session = sessionFactory.getCurrentSession();

        String date_from = deceasedCriteria.getDate_from_db()   != null ? deceasedCriteria.getDate_from_db()    : "2000-01-01 00:00:00";
        String date_to   = deceasedCriteria.getDate_to_db()     != null ? deceasedCriteria.getDate_to_db()      : "2025-01-01 01:00:00";
        Long specie_id   = deceasedCriteria.getSpecie_id();

        return session.createSQLQuery(
                "CALL getDeceasedByDateAndSpecie(:date_from, :date_to, :specie_id)")
                .addEntity(Deceased.class)
                .setParameter("date_from",  date_from)
                .setParameter("date_to",    date_to)
                .setParameter("specie_id",  specie_id)
                .list();
    }
}
