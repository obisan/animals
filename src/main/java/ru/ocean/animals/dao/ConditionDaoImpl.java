package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Condition;

import java.util.List;

@Repository
public class ConditionDaoImpl implements ConditionDao {
    private static final Logger logger = LoggerFactory.getLogger(ConditionDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addCondition(Condition condition) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(condition);
        logger.info("Condition successfully added. Condition details: " + condition);
    }

    public void updateCondition(Condition condition) {
        Session session = sessionFactory.getCurrentSession();
        session.update(condition);
        logger.info("Condition successfully updated. Condition details: " + condition);
    }

    public Condition getConditionById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Condition condition = (Condition) session.load(Condition.class, new Long(id));

        logger.info("Condition successfully loaded. Condition details: " + condition);
        return condition;
    }

    @SuppressWarnings("unchecked")
    public List<Condition> getConditions() {
        Session session = sessionFactory.getCurrentSession();

        List<Condition> conditions = session.createQuery("from Condition").list();
        logger.info("Condition list successfully loaded. Condition details: " + conditions);
        return conditions;
    }

    public void removeCondition(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Condition condition = (Condition) session.load(Condition.class, new Long(id));

        if(condition != null) {
            session.delete(condition);
        }
        logger.info("Condition successfully removed. Condition details: " + condition);
    }
}
