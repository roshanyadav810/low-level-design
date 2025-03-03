package example.librarymanagementsystem.route;

import example.librarymanagementsystem.entity.Order;
import example.librarymanagementsystem.service.IOrder;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {
    private final IOrder orderService;

    public OrderController(IOrder orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Order> createOrder(@RequestBody Order order){
       return ResponseEntity.ok(orderService.createOrder(order));
    }

    @RequestMapping(path = "/{orderId}",method = RequestMethod.GET)
    ResponseEntity<Order> createOrder(@PathVariable String orderId){
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Order>> getAllOrders(@RequestParam("userId") String userId){
        return ResponseEntity.ok(orderService.getAllOrder(userId));
    }


}
