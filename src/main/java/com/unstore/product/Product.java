package com.unstore.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinColumn;
import com.unstore.producer.Producer;
import com.unstore.product.enums.Unit;

@Getter @Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(nullable = false)
    private Long id;

    private String description;
    private int price;
    private Unit unit;
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "producerId")
    private Producer producer;
}
