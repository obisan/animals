package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.OrderDao;
import ru.ocean.animals.model.OrderN;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional("dubinets")
    public void addOrder(OrderN order) {
        this.orderDao.addOrder(order);
    }

    @Transactional("dubinets")
    public void updateOrder(OrderN order) {
        this.orderDao.updateOrder(order);
    }

    @Transactional("dubinets")
    public OrderN getOrderById(long id) {
        return this.orderDao.getOrderById(id);
    }

    @Transactional("dubinets")
    public List<OrderN> getOrders() {
        return this.orderDao.getOrders();
    }

    @Transactional("dubinets")
    public void removeOrder(long id) {
        this.orderDao.removeOrder(id);
    }
}
