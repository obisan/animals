package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Tank;

import java.util.List;

@Repository
public class TankDaoImpl implements TankDao {
    private static final Logger logger = LoggerFactory.getLogger(TankDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    public void addTank(Tank tank) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(tank);
        logger.info("Tank successfully added. Tank details: " + tank);
    }

    public void updateTank(Tank tank) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tank);
        logger.info("Tank successfully updated. Tank details: " + tank);
    }

    public Tank getTankById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Tank tank = (Tank) session.load(Tank.class, new Long(id));
        logger.info("Tank successfully loaded. Tank details: " + tank);
        return tank;
    }

    @SuppressWarnings("unchecked")
    public List<Tank> getTanks() {
        Session session = sessionFactory.getCurrentSession();

        List<Tank> tanks = session.createQuery("from Tank").list();
        for (Tank tank : tanks) {
            logger.info("Tank successfully loaded. Tank details: " + tank);
        }
        return tanks;
    }

    public void removeTank(long id) {
        Session session = sessionFactory.getCurrentSession();
        Tank tank = (Tank) session.load(Tank.class, new Long(id));

        if(tank != null) {
            session.delete(tank);
        }

        logger.info("Tank successfully removed. Tank details: " + tank);
    }
}
