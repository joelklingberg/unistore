package com.unistore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.unistore.order.dto.OrderMapper;
import com.unistore.order.dto.request.OrderRequest;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    
    private final OrderService orderService;
    private final OrderMapper mapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }
    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping()
    public Order createOrder(@RequestBody OrderRequest request) {
        Order order = mapper.orderRequestToOrder(request);
        return orderService.createOrder(order);
    }
    
    @PutMapping("/{id}")
    public Order updateOrder(
        @RequestBody Order updatedOrder,
        @PathVariable Long id
    ) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
