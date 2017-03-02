package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Class;

import java.util.List;

@Repository
public class ClassDaoImpl implements ClassDao {
    private static final Logger logger = LoggerFactory.getLogger(ClassDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addClass(Class aClass) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(aClass);
        logger.info("Class successfully added. Class details: " + aClass);
    }

    public void updateClass(Class aClass) {
        Session session = sessionFactory.getCurrentSession();
        session.update(aClass);

        logger.info("Class successfully added. Class details: " + aClass);
    }

    public Class getClassById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Class aClass = (Class) session.load(Class.class, new Long(id));
        logger.info("Class successfully loaded. Class details: " + aClass);
        return aClass;
    }

    @SuppressWarnings("unchecked")
    public List<Class> getClasses() {
        Session session = sessionFactory.getCurrentSession();

        List<Class> classes = session.createQuery("from Class").list();
        for(Class aClass : classes) {
            logger.info("Class successfully loaded. Class details: " + aClass);
        }

        return classes;
    }

    public void removeClass(long id) {
        Session session = sessionFactory.getCurrentSession();
        Class aClass = (Class) session.load(Class.class, new Long(id));

        if(aClass != null) {
            session.delete(aClass);
        }

        logger.info("Class successfully removed. Class details: " + aClass);
    }
}
