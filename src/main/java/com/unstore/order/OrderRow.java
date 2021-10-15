package com.unstore.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import com.unstore.product.Product;

@Getter @Setter
@Entity
@Table(name = "order_rows")
public class OrderRow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JsonIgnore
    private Long id;

    private int quantity;
    private int price;

    @Column(insertable = false, updatable = false)
    @JsonProperty(access = Access.READ_ONLY)
    @Transient
    private int orderRowTotal;  // Virtual column.

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    public int getOrderRowTotal() {
        return quantity * price;
    }

    public void setOrderRowTotal() {
        this.orderRowTotal = quantity * price;
    }

}
