package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.GroupAllowance;

import java.util.List;

@Repository
public class GroupAllowanceDaoImpl implements GroupAllowanceDao {
    private static final Logger logger = LoggerFactory.getLogger(GroupAllowanceDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addGroupAllowance(GroupAllowance groupAllowance) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(groupAllowance);
        logger.info("GroupAllowance successfully added. GroupAllowance details: " + groupAllowance);
    }

    public void updateGroupAllowance(GroupAllowance groupAllowance) {
        Session session = sessionFactory.getCurrentSession();
        session.update(groupAllowance);
        logger.info("GroupAllowance successfully updated. GroupAllowance details: " + groupAllowance);
    }

    public GroupAllowance getGroupAllowanceById(long id) {
        Session session = sessionFactory.getCurrentSession();

        GroupAllowance groupAllowance = (GroupAllowance) session.load(GroupAllowance.class, new Long(id));
        logger.info("GroupAllowance successfully loaded. GroupAllowance details: " + groupAllowance);
        return groupAllowance;
    }

    @SuppressWarnings("unchecked")
    public List<GroupAllowance> getGroupAllowances() {
        Session session = sessionFactory.getCurrentSession();
        return (List<GroupAllowance>) session.createQuery("from GroupAllowance order by group_name").list();
    }


    public void removeGroupAllowance(long id) {
        Session session = sessionFactory.getCurrentSession();

        GroupAllowance groupAllowance = (GroupAllowance) session.load(GroupAllowance.class, new Long(id));
        if(groupAllowance != null) {
            session.delete(groupAllowance);
        }

        logger.info("GroupAllowance successfully removed. GroupAllowance details: " + groupAllowance);
    }
}
