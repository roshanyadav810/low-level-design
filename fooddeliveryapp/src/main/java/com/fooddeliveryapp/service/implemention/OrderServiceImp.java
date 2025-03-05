package com.fooddeliveryapp.service.implemention;

import com.fooddeliveryapp.entity.DeliveryAgent;
import com.fooddeliveryapp.entity.Order;
import com.fooddeliveryapp.entity.Payment;
import com.fooddeliveryapp.entity.enums.OrderStatus;
import com.fooddeliveryapp.entity.enums.PaymentStatus;
import com.fooddeliveryapp.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImp implements IOrderService {

    private final Map<String, Order> orderDb;

    public OrderServiceImp() {
        this.orderDb = new HashMap<>();
    }

    @Override
    public Order create(Order order) {
        String id = UUID.randomUUID().toString();
        order.setOrderId(id);
        orderDb.put(id,order);
        return order;
    }

    @Override
    public Order updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orderDb.getOrDefault(orderId,null);
        if(Objects.nonNull(order)){
            order.setStatus(status);
        }
        return order;
    }

    @Override
    public Order makePayment(String orderId, Payment payment) {
        Order order = orderDb.getOrDefault(orderId,null);
        if(Objects.nonNull(order)){
            payment.setId(UUID.randomUUID().toString());
            payment.setStatus(PaymentStatus.COMPLETED);
            order.setStatus(OrderStatus.PAYMENT_SUCCESS);
            order.setPayment(payment);
        }
        return order;
    }

    @Override
    public Order assignDeliveryPartner(String orderId, DeliveryAgent deliveryAgent) {
        Order order = orderDb.getOrDefault(orderId,null);
        if(Objects.nonNull(order)){
            deliveryAgent.setId(UUID.randomUUID().toString());
            order.setStatus(OrderStatus.DELIVERY_AGENT_ASSIGNED);
            order.setDeliveryAgent(deliveryAgent);
        }
        return order;
    }
}
