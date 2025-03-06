package com.fooddeliveryapp.entity;

import com.fooddeliveryapp.entity.enums.OrderStatus;
import lombok.Data;

import java.util.List;


@Data
public class Order {
    private String orderId;
    private List<CartItem> items;
    private Payment payment;
    private DeliveryAgent deliveryAgent;
    private User user;
    private OrderStatus status;
}
