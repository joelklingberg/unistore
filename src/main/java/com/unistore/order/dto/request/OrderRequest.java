package com.unistore.order.dto.request;

import java.util.Date;
import java.util.List;
import com.unistore.order.enums.PaymentMethod;
import com.unistore.order.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequest {
    private Date orderDate;
    private String deliveryAddress;
    private Date deliveryDate;
    private PaymentMethod paymentMethod;
    private Status status;    
    private List<OrderRowRequest> orderRows;
    //private Long customerId;
}
