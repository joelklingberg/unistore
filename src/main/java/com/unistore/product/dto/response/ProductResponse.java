package com.unistore.product.dto.response;

import lombok.Setter;
import lombok.Getter;
import com.unistore.product.enums.Unit;

@Getter @Setter
public class ProductResponse {
    private Long id;
    private String description;
    private int price;
    private Unit unit;
    private String name;
    private Long manufacturerId;
}
