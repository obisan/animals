package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Genus;

import java.util.List;

@Repository
public class GenusDaoImpl implements GenusDao {
    private static final Logger logger = LoggerFactory.getLogger(GenusDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addGenus(Genus genus) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(genus);
        logger.info("Genus successfully added. Genus details: " + genus);
    }

    public void updateGenus(Genus genus) {
        Session session = sessionFactory.getCurrentSession();
        session.update(genus);
        logger.info("Genus successfully updated. Genus details: " + genus);
    }

    public Genus getGenusById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Genus genus = (Genus) session.load(Genus.class, new Long(id));
        logger.info("Genus successfully loaded. Genus details: " + genus);
        return genus;
    }

    @SuppressWarnings("unchecked")
    public List<Genus> getGenuses() {
        Session session = sessionFactory.getCurrentSession();
        List<Genus> genera = session.createQuery("from Genus").list();

        for (Genus genus : genera) {
            logger.info("Genus successfully loaded. Genus details: " + genus);
        }
        return genera;
    }

    public void removeGenus(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Genus genus = (Genus) session.load(Genus.class, new Long(id));

        if(genus != null) {
            session.delete(genus);
        }

        logger.info("Genus successfully removed. Genus details: " + genus);
    }
}
