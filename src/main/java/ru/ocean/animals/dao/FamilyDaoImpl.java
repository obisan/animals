package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Family;

import java.util.List;

@Repository
public class FamilyDaoImpl implements FamilyDao {
    private static final Logger logger = LoggerFactory.getLogger(FamilyDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addFamily(Family family) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(family);
        logger.info("Family successfully added. Family details: " + family);
    }

    public void updateFamily(Family family) {
        Session session = sessionFactory.getCurrentSession();
        session.update(family);
        logger.info("Family successfully updated. Family details: " + family);
    }

    public Family getFamilyById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Family family = (Family) session.load(Family.class, new Long(id));
        logger.info("Family successfully loaded. Family details: " + family);
        return family;
    }

    @SuppressWarnings("unchecked")
    public List<Family> getFamilies() {
        Session session = sessionFactory.getCurrentSession();

        List<Family> families = session.createQuery("from Family").list();
        for(Family family : families) {
            logger.info("Family successfully loaded. Family details: " + family);
        }
        return families;
    }

    public void removeFamily(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Family family = (Family) session.load(Family.class, new Long(id));

        if(family != null) {
            session.delete(family);
        }

        logger.info("Family successfully removed. Family details: " + family);
    }
}
