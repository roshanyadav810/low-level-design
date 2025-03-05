package com.fooddeliveryapp.service;

import com.fooddeliveryapp.entity.DeliveryAgent;
import com.fooddeliveryapp.entity.Order;
import com.fooddeliveryapp.entity.Payment;
import com.fooddeliveryapp.entity.enums.OrderStatus;

public interface IOrderService {
    Order create(Order order);

    Order updateOrderStatus(String orderId, OrderStatus status);

    Order makePayment(String orderId, Payment payment);

    Order assignDeliveryPartner(String orderId, DeliveryAgent deliveryAgent);

}
