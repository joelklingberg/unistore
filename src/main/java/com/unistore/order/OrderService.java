package com.unistore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

import com.unistore.order.enums.Status;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        java.sql.Date todaysDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        order.setOrderDate(todaysDate);
        order.setStatus(Status.PENDING);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        try {
            return orderRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, Order newOrder) {
        Order oldOrder = orderRepository.findById(id).get();

        if(oldOrder != null) {
            newOrder.setId(id);
            return orderRepository.save(newOrder);
        }

        return null;
    }
}
