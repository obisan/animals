package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.JournalAllowance;

import java.util.List;

@Repository
public class JournalAllowanceDaoImpl implements JournalAllowanceDao {
    private static final Logger logger = LoggerFactory.getLogger(JournalAllowanceDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addJournalAllowance(JournalAllowance journalAllowance) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(journalAllowance);
        logger.info("JournalAllowance successfully added. JournalAllowance details: " + journalAllowance);
    }

    @Override
    public void updateJournalAllowance(JournalAllowance journalAllowance) {
        Session session = sessionFactory.getCurrentSession();
        session.update(journalAllowance);
        logger.info("JournalAllowance successfully updated. JournalAllowance details: " + journalAllowance);
    }

    @Override
    public JournalAllowance getJournalAllowanceById(long id) {
        Session session = sessionFactory.getCurrentSession();
        JournalAllowance journalAllowance = (JournalAllowance) session.load(JournalAllowance.class, new Long(id));
        logger.info("JournalAllowance successfully loaded. JournalAllowance details: " + journalAllowance);
        return journalAllowance;
    }

    @SuppressWarnings("unchecked")
    public List<JournalAllowance> getJournalAllowances() {
        Session session = sessionFactory.getCurrentSession();
        return (List<JournalAllowance>) session.createQuery("from JournalAllowance").list();
    }

    @Override
    public void removeJournalAllowance(long id) {
        Session session = sessionFactory.getCurrentSession();

        JournalAllowance journalAllowance = (JournalAllowance) session.load(JournalAllowance.class, new Long(id));
        if(journalAllowance != null) {
            session.delete(journalAllowance);
        }
        logger.info("JournalAllowance successfully removed. JournalAllowance details: " + journalAllowance);
    }
}
