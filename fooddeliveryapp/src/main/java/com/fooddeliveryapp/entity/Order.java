package com.fooddeliveryapp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String orderId;
    private List<Dish> dishList;
    private Payment payment;
    private DeliveryAgent deliveryAgent;
    private OrderStatus status;
}
