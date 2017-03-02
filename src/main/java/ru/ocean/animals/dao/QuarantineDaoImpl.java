package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Quarantine;

import java.util.List;

@Repository
public class QuarantineDaoImpl implements QuarantineDao {
    private static final Logger logger = LoggerFactory.getLogger(QuarantineDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addQuarantine(Quarantine quarantine) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(quarantine);
        logger.info("Quarantine successfully added. Quarantine details: " + quarantine);
    }

    public void updateQuarantine(Quarantine quarantine) {
        Session session = sessionFactory.getCurrentSession();
        session.update(quarantine);
        logger.info("Quarantine successfully updated. Quarantine details: " + quarantine);

    }

    public Quarantine getQuarantineById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Quarantine quarantine = (Quarantine) session.load(Quarantine.class, new Long(id));
        logger.info("Quarantine successfully loaded. Quarantine details: " + quarantine);
        return quarantine;
    }

    @SuppressWarnings("unchecked")
    public List<Quarantine> getQuarantines() {
        Session session = sessionFactory.getCurrentSession();

        List<Quarantine> quarantines = session.createQuery("from Quarantine").list();
        for(Quarantine quarantine : quarantines) {
            logger.info("Quarantine successfully loaded. Quarantine details: " + quarantine);
        }
        return quarantines;
    }

    public void removeQuarantine(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Quarantine quarantine = (Quarantine) session.load(Quarantine.class, new Long(id));
        if(quarantine != null) {
            session.delete(quarantine);
        }
        logger.info("Quarantine successfully removed. Quarantine details: " + quarantine);

    }
}
