package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Allowance;

import java.util.List;

@Repository
public class AllowanceDaoImpl implements AllowanceDao {
    private static final Logger logger = LoggerFactory.getLogger(AllowanceDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAllowance(Allowance allowance) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(allowance);
        logger.info("Allowance successfully added. Allowance details: " + allowance);
    }

    @Override
    public void updateAllowance(Allowance allowance) {
        Session session = sessionFactory.getCurrentSession();
        session.update(allowance);
        logger.info("Allowance successfully updated. Allowance details: " + allowance);
    }

    @Override
    public Allowance getAllowanceById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Allowance allowance = (Allowance) session.load(Allowance.class, new Long(id));
        logger.info("Allowance successfully loaded. Allowance details: " + allowance);
        return allowance;
    }

    @SuppressWarnings("unchecked")
    public List<Allowance> getAllowances() {
        Session session = sessionFactory.getCurrentSession();
        List<Allowance> allowances = session.createQuery("from Allowance").list();
        logger.info("Allowance list successfully loaded. Allowance details: " + allowances);
        return allowances;
    }

    @Override
    public void removeAllowance(long id) {
        Session session = sessionFactory.getCurrentSession();

        Allowance allowance = (Allowance) session.load(Allowance.class, new Long(id));
        if(allowance != null) {
            session.delete(allowance);
        }
        logger.info("Allowance successfully removed. Allowance details: " + allowance);
    }
}
