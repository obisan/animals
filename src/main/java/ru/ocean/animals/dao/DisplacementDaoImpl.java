package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Displacement;

import java.util.List;

@Repository
public class DisplacementDaoImpl implements DisplacementDao {
    private static final Logger logger = LoggerFactory.getLogger(DisplacementDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    public void addDisplacement(Displacement displacement) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(displacement);
        logger.info("Displacement successfully added. Displacement details: " + displacement);
    }

    public void updateDisplacement(Displacement displacement) {
        Session session = sessionFactory.getCurrentSession();
        session.update(displacement);
        logger.info("Displacement successfully update. Displacement details: " + displacement);
    }

    public Displacement getDisplacementById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Displacement displacement = (Displacement) session.load(Displacement.class, new Long(id));

        logger.info("Displacement successfully loaded. Displacement details: " + displacement);
        return displacement;
    }

    @SuppressWarnings("unchecked")
    public List<Displacement> getDisplacementOfObject(long animal_id) {
        Session session = sessionFactory.getCurrentSession();
        return (List<Displacement>) session.createQuery("from Displacement where animal_id = :animal_id order by date_arrival")
                .setParameter("animal_id", animal_id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Displacement> getDisplacements() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Displacement>) session.createQuery("from Displacement").list();
    }

    public void removeDisplacement(long id) {
        Session session = sessionFactory.getCurrentSession();
        Displacement displacement = (Displacement) session.load(Displacement.class, new Long(id));

        if(displacement != null) {
            session.delete(displacement);
        }

        logger.info("Displacement successfully removed. Displacement details: " + displacement);
    }
}
