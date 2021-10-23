package com.unistore.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import com.unistore.order.Order;
import java.util.List;
import java.io.Serializable;
import javax.persistence.FetchType;

@Getter @Setter
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    
    private String fullName;
    private String address;
    private String phoneNo;
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> order;
}
