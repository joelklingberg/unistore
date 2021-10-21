package com.unistore.manufacturer.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ManufacturerResponse {
    Long id;
    String name;
    String address;
    String phoneNo;
    String customerContactEmail;
}
