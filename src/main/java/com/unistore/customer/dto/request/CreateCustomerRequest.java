package com.unistore.customer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateCustomerRequest {
    private String fullName;
    private String address;
    private String phoneNo;
    private String email;
}
