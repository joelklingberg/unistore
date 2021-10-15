package com.unstore.producer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.persistence.JoinColumn;
import com.unstore.product.Product;

@Getter @Setter
@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(nullable = false)
    private Long id;

    String name;
    String address;
    String phoneNo;
    String customerContactEmail;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "producerId")
    private List<Product> products;
    
}
