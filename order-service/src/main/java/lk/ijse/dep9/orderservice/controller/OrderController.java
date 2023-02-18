package lk.ijse.dep9.orderservice.controller;

import lk.ijse.dep9.basedomains.dto.Order;
import lk.ijse.dep9.basedomains.dto.OrderEvent;
import lk.ijse.dep9.basedomains.dto.Status;
import lk.ijse.dep9.orderservice.kafka.OrderProducer;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer){
        this.orderProducer=orderProducer;
    }
    @PostMapping
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setStatus(Status.NEW);
        orderEvent.setMessage("Order status is new");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "Order Placed succefully";
    }
}
