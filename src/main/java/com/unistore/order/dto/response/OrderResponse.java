package com.unistore.order.dto.response;

import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.unistore.order.enums.PaymentMethod;
import com.unistore.order.enums.Status;

import lombok.Getter;

@Getter @Setter
public class OrderResponse {
    private Long id;
    private Date orderDate;
    private String deliveryAddress;
    private Date deliveryDate;
    private PaymentMethod paymentMethod;
    private Status status;
    private List<OrderRowResponse> orderRows;
    private int orderTotal;
}
