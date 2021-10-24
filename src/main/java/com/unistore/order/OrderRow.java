package com.unistore.order;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import com.unistore.product.Product;

@Getter @Setter
@Entity
@Table(name = "order_rows")
public class OrderRow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private int quantity;
    private int price;

    @Column(insertable = false, updatable = false)
    @JsonProperty(access = Access.READ_ONLY)
    @Transient
    private int orderRowTotal;  // Virtual column.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    public int getOrderRowTotal() {
        return quantity * price;
    }

}
