package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Label;

import java.util.List;

@Repository
public class LabelDaoImpl implements LabelDao{
    private static final Logger logger = LoggerFactory.getLogger(LabelDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addLabel(Label label) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(label);
        logger.info("Label successfully added. Label details: " + label);
    }

    public void updateLabel(Label label) {
        Session session = sessionFactory.getCurrentSession();
        session.update(label);
        logger.info("Label successfully updated. Label details: " + label);
    }

    public Label getLabelById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Label label = (Label) session.load(Label.class, new Long(id));
        logger.info("Label successfully loaded. Label details: " + label);
        return label;
    }

    @SuppressWarnings("unchecked")
    public List<Label> getLabels() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Label>) session.createQuery("from Label").list();
    }

    public void removeLabel(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Label label = (Label) session.load(Label.class, new Long(id));
        if(label != null) {
            session.delete(label);
        }
        logger.info("Label successfully removed. Label details: " + label);
    }
}
