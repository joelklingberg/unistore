package com.unstore.orderrow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import java.util.Date;
import java.io.Serializable;
import com.unstore.product.Product;
import com.unstore.order.Order;


@Getter @Setter
@Entity
@Table(name = "order_rows")
public class OrderRow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(nullable = false)
    private Long id;

    private int quantity;
    private int price;

    @Column(insertable = false, updatable = false)
    @JsonProperty(access = Access.READ_ONLY)
    @Transient
    private int orderRowTotal;  // Virtual column.

    /* RELATIONS */
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    /* GETTERS / SETTERS */

    public int getOrderRowTotal() {
        return quantity * price;
    }

    public void setOrderRowTotal() {
        this.orderRowTotal = quantity * price;
    }

}
