package com.unistore.test;

import com.unistore.customer.Customer;
import com.unistore.manufacturer.Manufacturer;
import com.unistore.order.Order;
import com.unistore.order.OrderRow;
import com.unistore.order.enums.PaymentMethod;
import com.unistore.order.enums.Status;
import com.unistore.product.Product;
import com.unistore.product.enums.Unit;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class TestEntityStore {

    private Order order;
    private Product product;
    private Manufacturer manufacturer;
    private Customer customer;

    public Order getTestOrder() {
        if(this.order == null) {
            createTestOrder();
        }
        return this.order;
    }

    public void createTestOrder() {
        Order order = new Order();

        order.setDeliveryAddress("Test address 321");
        java.sql.Date todaysDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        order.setDeliveryDate(todaysDate);
        order.setOrderDate(todaysDate);
        order.setPaymentMethod(PaymentMethod.DEBIT_CARD);
        order.setStatus(Status.PENDING);

        // Add order rows.
        List<OrderRow> orderRows = new ArrayList<OrderRow>();

        for(int i = 0; i < 5; i++) {
            orderRows.add(this.createTestOrderRow());
        }

        order.setOrderRows(orderRows);

        order.setCustomer(getTestCustomer());

        this.order = order;
    }

    private OrderRow createTestOrderRow() {
        OrderRow orderRow = new OrderRow();
        orderRow.setPrice(100);
        orderRow.setQuantity(50);

        return orderRow;
    }

    public Customer getTestCustomer() {
        if(this.customer == null) {
            createTestCustomer();
        }
        return this.customer;
    }

    private void createTestCustomer() {
        Customer customer = new Customer();

        customer.setAddress("Test address");
        customer.setEmail("test@email.com");
        customer.setFullName("Test Name");
        customer.setPhoneNo("1234567890");

        this.customer = customer;
    }

    public Product getTestProduct() {
        if(this.product == null) {
            createTestProduct();
        }
        return this.product;
    }

    private void createTestProduct() {
        Product product = new Product();

        product.setDescription("Test description");
        product.setName("Test product");
        product.setPrice(500);
        product.setUnit(Unit.EACH);

        this.product = product;
    }

    public Manufacturer getTestManufacturer() {
        if(this.manufacturer == null) {
            createTestManufacturer();
        }
        return this.manufacturer;
    }

    private void createTestManufacturer() {
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setCustomerContactEmail("Test@email.com");
        manufacturer.setName("Test manufacturer");
        manufacturer.setAddress("Test address");
        manufacturer.setPhoneNo("01010101");

        this.manufacturer = manufacturer;
    }

}
