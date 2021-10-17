package com.unistore.order.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRowRequest {
    private int quantity;
    private Long productId;
    //private int price;
}
