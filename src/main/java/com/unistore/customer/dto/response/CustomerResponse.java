package com.unistore.customer.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerResponse {
    private Long id;
    private String fullName;
    private String address;
    private String phoneNo;
    private String email;
}
