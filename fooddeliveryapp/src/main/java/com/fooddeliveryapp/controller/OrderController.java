package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.entity.DeliveryAgent;
import com.fooddeliveryapp.entity.Order;
import com.fooddeliveryapp.entity.Payment;
import com.fooddeliveryapp.entity.enums.OrderStatus;
import com.fooddeliveryapp.service.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> create(Order order){
        return ResponseEntity.ok(orderService.create(order));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{orderId}/status/{status}")
    public ResponseEntity<Order>  updateOrderStatus(@PathVariable String orderId, @PathVariable OrderStatus status){
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId,status));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{orderId}/payment")
    public ResponseEntity<Order>  makePayment(@PathVariable String orderId, @RequestBody Payment payment){
        return ResponseEntity.ok(orderService.makePayment(orderId,payment));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{orderId}/delivery-agent")
    public ResponseEntity<Order>  assignDeliveryPartner(@PathVariable String orderId, @RequestBody DeliveryAgent deliveryAgent){
        return ResponseEntity.ok(orderService.assignDeliveryPartner(orderId,deliveryAgent));
    }

}
