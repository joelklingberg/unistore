package com.unistore.product.dto.request;

import com.unistore.product.enums.Unit;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRequest {
    private String description;
    private int price;
    private Unit unit;
    private String name;
    private Long manufacturerId;
}
