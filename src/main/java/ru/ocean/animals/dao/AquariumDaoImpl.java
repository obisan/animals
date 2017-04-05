package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Aquarium;

import java.util.List;

@Repository
public class AquariumDaoImpl implements AquariumDao {
    private static final Logger logger = LoggerFactory.getLogger(AquariumDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAquarium(Aquarium aquarium) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(aquarium);
        logger.info("Aquarium successfully added. Aquarium details: " + aquarium);
    }

    @Override
    public void updateAquarium(Aquarium aquarium) {
        Session session = sessionFactory.getCurrentSession();
        session.update(aquarium);
        logger.info("Aquarium successfully updated. Aquarium details: " + aquarium);
    }

    @Override
    public Aquarium getAquariumById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Aquarium aquarium = (Aquarium) session.load(Aquarium.class, new Long(id));
        logger.info("Aquarium successfully loaded. Aquarium details: " + aquarium);
        return aquarium;
    }

    @SuppressWarnings("unchecked")
    public List<Aquarium> getAquariums() {
        Session session = sessionFactory.getCurrentSession();
        List<Aquarium> aquariums = session.createQuery("from Aquarium").list();
        logger.info("Aquariums list successfully loaded. Aquarium details: " + aquariums);
        return aquariums;
    }

    @Override
    public void removeAquarium(long id) {
        Session session = sessionFactory.getCurrentSession();
        Aquarium aquarium = (Aquarium) session.load(Aquarium.class, new Long(id));
        if(aquarium != null) {
            session.delete(aquarium);
        }
        logger.info("Aquarium successfully removed. Aquarium details: " + aquarium);
    }
}
