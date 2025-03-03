package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.Order;

import java.util.List;

public interface IOrder {
    Order createOrder(Order order);
    Order getOrder(String orderId);
    List<Order> getAllOrder(String userId);
}
