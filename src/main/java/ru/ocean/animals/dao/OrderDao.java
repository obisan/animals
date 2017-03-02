package ru.ocean.animals.dao;

import ru.ocean.animals.model.OrderN;

import java.util.List;

public interface OrderDao {
    void            addOrder(OrderN order);
    void            updateOrder(OrderN order);
    OrderN          getOrderById(long id);
    List<OrderN>    getOrders();
    void            removeOrder(long id);
}
