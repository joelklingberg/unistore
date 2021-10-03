package com.unstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.Calendar;

import com.unstore.order.enums.PaymentMethod;
import com.unstore.order.enums.Status;
import com.unstore.order.OrderController;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class OrderTest {

	@Autowired
	private OrderController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	private Order getTestOrder() {
		Order order = new Order();

		order.setDeliveryAddress("Test address 321");
        java.sql.Date todaysDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        order.setDeliveryDate(todaysDate);
        order.setOrderDate(todaysDate);
        order.setPaymentMethod(PaymentMethod.DEBIT_CARD);
        order.setStatus(Status.PENDING);

		return order;
	}

	@Test
	public void createOrder() throws Exception {
		Order order = getTestOrder();

		// Create order.
		Order createdOrder = controller.createOrder(order);

		// Assert that values are stored correctly.
		assertThat(createdOrder).isNotNull();
		assertThat(createdOrder.getId()).isEqualTo(order.getId());
		assertThat(createdOrder.getDeliveryAddress()).isEqualTo(order.getDeliveryAddress());
		assertThat(createdOrder.getDeliveryDate()).isEqualTo(order.getDeliveryDate());
		assertThat(createdOrder.getOrderDate()).isEqualTo(order.getOrderDate());
		assertThat(createdOrder.getPaymentMethod()).isEqualTo(order.getPaymentMethod());
		assertThat(createdOrder.getStatus()).isEqualTo(order.getStatus());

		// Retrieve order.
		Order storedOrder = controller.getOrderById(createdOrder.getId());
		assertThat(storedOrder).isNotNull();
	}

	@Test
	public void updateOrder() throws Exception {
		Order order = getTestOrder();

		// Create order.
		Order createdOrder = controller.createOrder(order);

		// Update order.
		createdOrder.setDeliveryAddress("New Delivery Address");
		Order updatedOrder = controller.updateOrder(createdOrder, createdOrder.getId());

		assertThat(createdOrder.getDeliveryAddress()).isEqualTo(updatedOrder.getDeliveryAddress());
	}
	
	@Test
	public void deleteOrder() throws Exception {
		Order order = getTestOrder();

		// Create order.
		Order createdOrder = controller.createOrder(order);

		// Delete order.
		controller.deleteOrder(createdOrder.getId());

		// Attempt to retrieve deleted order.
		Order deletedOrder = controller.getOrderById(createdOrder.getId());

		assertThat(deletedOrder).isNull();
	}

}