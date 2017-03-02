package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.OrderN;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addOrder(OrderN order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
        logger.info("Order successfully added. Order details: " + order);
    }

    public void updateOrder(OrderN order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
        logger.info("Order successfully updated. Order details: " + order);
    }

    public OrderN getOrderById(long id) {
        Session session = sessionFactory.getCurrentSession();

        OrderN order = (OrderN) session.load(OrderN.class, new Long(id));
        logger.info("Order successfully loaded. Order details: " + order);
        return order;
    }

    @SuppressWarnings("unchecked")
    public List<OrderN> getOrders() {
        Session session = sessionFactory.getCurrentSession();

        List<OrderN> orders = session.createQuery("from OrderN").list();
        for (OrderN order : orders) {
            logger.info("Order successfully loaded. Order details: " + order);
        }
        return orders;
    }

    public void removeOrder(long id) {
        Session session = sessionFactory.getCurrentSession();
        OrderN order = (OrderN) session.load(OrderN.class, new Long(id));

        if(order != null) {
            session.delete(order);
        }

        logger.info("Order successfully removed. Order details: " + order);
    }
}
