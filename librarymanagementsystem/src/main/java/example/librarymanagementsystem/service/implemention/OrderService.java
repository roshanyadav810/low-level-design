package example.librarymanagementsystem.service.implemention;

import example.librarymanagementsystem.entity.Order;
import example.librarymanagementsystem.repository.OrderRepository;
import example.librarymanagementsystem.service.IOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService implements IOrder {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(String orderId) {
        Optional<Order> optionalOrder =  orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            throw new RuntimeException("order not found");
        }
        return optionalOrder.get();
    }

    @Override
    public List<Order> getAllOrder(String userId) {
        return List.of();
    }
}
