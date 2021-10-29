package com.unistore.order.dto.request;

import java.util.List;
import com.unistore.order.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequest {

    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private List<OrderRowRequest> orderRows;

    // Handled by backend:
    //private Date deliveryDate;
    //private Date orderDate;
    private Long customerId;
    //private Status status;
}
