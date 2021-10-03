package com.unstore.orderrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderRowService {
    
    private final OrderRowRepository orderRowRepository;
    
    @Autowired
    public OrderRowService(OrderRowRepository orderRowRepository) {
        this.orderRowRepository = orderRowRepository;
    }

    public List<OrderRow> getAllOrderRows() {
        return orderRowRepository.findAll();
    }

    public OrderRow createOrderRow(OrderRow orderRow) {
        return orderRowRepository.save(orderRow);
    }

    public OrderRow getOrderRowById(Long id) {
        try {
            return orderRowRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteOrderRow(Long id) {
        orderRowRepository.deleteById(id);
    }

    public OrderRow updateOrderRow(Long id, OrderRow newOrderRow) {
        OrderRow oldOrderRow = orderRowRepository.findById(id).get();

        if(oldOrderRow != null) {
            newOrderRow.setId(id);
            return orderRowRepository.save(newOrderRow);
        }

        return null;
    }
}
