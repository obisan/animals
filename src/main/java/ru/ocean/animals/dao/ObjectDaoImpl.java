package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Object;

import java.util.List;

@Repository
public class ObjectDaoImpl implements ObjectDao {
    private static final Logger logger = LoggerFactory.getLogger(ObjectDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    public void addObject(Object object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
        logger.info("Object successfully added. Object details: " + object);
    }

    public void updateObject(Object object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
        logger.info("Object successfully updated. Object details: " + object);
    }

    public Object getObjectById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Object object = (Object) session.load(Object.class, new Long(id));
        logger.info("Object successfully loaded. Object details: " + object);
        return object;
    }

    @SuppressWarnings("unchecked")
    public List<Object> getObjectsAlive() {
        Session session = sessionFactory.getCurrentSession();

        List<Object> objects = session.createQuery("from Object where object_count > 0").list();
        for(Object object : objects) {
            logger.info("Object successfully loaded. Object details: " + object);
        }
        return objects;
    }

    @SuppressWarnings("unchecked")
    public List<Object> getObjectsWithDeads() {
        Session session = sessionFactory.getCurrentSession();

        List<Object> objects = session.createQuery("from Object").list();
        for(Object object : objects) {
            logger.info("Object successfully loaded. Object details: " + object);
        }
        return objects;
    }

    @SuppressWarnings("unckecked")
    public List<Object> getObjectsFilteredBySpecieId(long specie_id) {
        Session session = sessionFactory.getCurrentSession();

        List<Object> objects = session.createSQLQuery(
                "CALL getObjectsFilteredBySpecieId(:specie_id)")
                .addEntity(Object.class)
                .setParameter("specie_id", specie_id).list();

        return objects;
    }

    public void removeObject(long id) {
        Session session = sessionFactory.getCurrentSession();

        Object object = (Object) session.load(Object.class, new Long(id));

        if(object != null) {
            session.delete(object);
        }
        logger.info("Object successfully removed. Object details: " + object);
    }
}
