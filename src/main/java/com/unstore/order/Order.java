package com.unstore.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import com.unstore.customer.Customer;

@Getter @Setter
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(nullable = false)
    private Long id;

    private Date orderDate;
    private String deliveryAddress;
    private Date deliveryDate;
    private String paymentMethod;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Customer customer;
}
