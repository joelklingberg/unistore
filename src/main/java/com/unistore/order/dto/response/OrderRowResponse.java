package com.unistore.order.dto.response;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter
public class OrderRowResponse {
    private Long id;

    private int quantity;
    private int price;
    private int orderRowTotal;
    
    // private Product product;

    private Long productId;
}
