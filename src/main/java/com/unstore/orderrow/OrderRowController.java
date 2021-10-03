package com.unstore.orderrow;

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

@RestController
@RequestMapping(value = "/orderrows")
public class OrderRowController {
    
    private final OrderRowService orderRowService;

    @Autowired
    public OrderRowController(OrderRowService orderRowService) {
        this.orderRowService = orderRowService;
    }
    
    @GetMapping
    public List<OrderRow> getAllOrderRows() {
        return orderRowService.getAllOrderRows();
    }

    @GetMapping("/{id}")
    public OrderRow getOrderRowById(@PathVariable Long id) {
        return orderRowService.getOrderRowById(id);
    }

    @PostMapping()
    public OrderRow createOrderRow(@RequestBody OrderRow orderRow) {
        return orderRowService.createOrderRow(orderRow);
    }
    
    @PutMapping("/{id}")
    public OrderRow updateOrderRow(
        @RequestBody OrderRow updatedOrderRow,
        @PathVariable Long id
    ) {
        return orderRowService.updateOrderRow(id, updatedOrderRow);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderRow(@PathVariable Long id) {
        orderRowService.deleteOrderRow(id);
    }

}
