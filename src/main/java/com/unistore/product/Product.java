package com.unistore.product;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.unistore.order.OrderRow;
import lombok.Getter;
import lombok.Setter;
import com.unistore.manufacturer.Manufacturer;
import com.unistore.product.enums.Unit;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String description;
    private int price;
    private Unit unit;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturerId", nullable = false)
    private Manufacturer manufacturer;
}
