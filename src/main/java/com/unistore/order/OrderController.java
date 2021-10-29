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
import com.unistore.order.dto.response.OrderResponse;

@RestController
@RequestMapping("${api}/orders")
public class OrderController {
    
    private final OrderService orderService;
    private final OrderMapper mapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }
    
    @GetMapping
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return mapper.ordersToOrderResponses(orders);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return mapper.orderToOrderResponse(order);
    }

    @PostMapping()
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        Order order = mapper.orderRequestToOrder(request);
        Order createdOrder = orderService.createOrder(order);
        return mapper.orderToOrderResponse(createdOrder);
    }
    
    @PutMapping("/{id}")
    public OrderResponse updateOrder(
        @RequestBody OrderRequest updateOrderRequest,
        @PathVariable Long id
    ) {
        Order orderToUpdate = mapper.orderRequestToOrder(updateOrderRequest);
        Order updatedOrder = orderService.updateOrder(id, orderToUpdate);
        return mapper.orderToOrderResponse(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
