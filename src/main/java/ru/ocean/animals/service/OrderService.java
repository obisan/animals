package ru.ocean.animals.service;

import ru.ocean.animals.model.OrderN;

import java.util.List;

public interface OrderService {
    void            addOrder(OrderN order);
    void            updateOrder(OrderN order);
    OrderN          getOrderById(long id);
    List<OrderN>    getOrders();
    void            removeOrder(long id);
}
