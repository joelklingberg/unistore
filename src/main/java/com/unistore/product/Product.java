package com.unistore.product;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.unistore.manufacturer.Manufacturer;
import com.unistore.product.enums.Unit;
import static com.unistore.core.configuration.PersistenceConfig.ALLOW_NULL_VALUES;

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
    @JoinColumn(name = "manufacturerId", nullable = ALLOW_NULL_VALUES)
    private Manufacturer manufacturer;
}
