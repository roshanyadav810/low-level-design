package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.Order;

public interface IOrder {
    Order createOrder(Order order);
    Order getOrder(Order order);
    Order getAllOrder(Order order);
}
