package com.unistore.order;

import com.unistore.test.TestEntityStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Calendar;
import com.unistore.order.dto.OrderMapper;
import com.unistore.order.dto.request.OrderRequest;
import com.unistore.order.dto.response.OrderResponse;
import java.util.List;
import static com.unistore.core.configuration.TestConfig.TEST_PROPERTY_SOURCE;

@SpringBootTest
@TestPropertySource(locations = TEST_PROPERTY_SOURCE)
public class OrderTest {

	@Autowired
	private OrderController controller;

	@Autowired
	private OrderMapper mapper;

	@Autowired
	private TestEntityStore testEntityStore;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	private Order getTestOrder() {
		return testEntityStore.getTestOrder();
	}

	@Test
	public void createOrder() throws Exception {
		Order order = getTestOrder();
		List<OrderRow> orderRow = order.getOrderRows();
		
		// Create order.
		OrderRequest request = mapper.orderToOrderRequest(order);
		OrderResponse createdOrderResponse = controller.createOrder(request);
		Order createdOrder = mapper.orderResponseToOrder(createdOrderResponse);

		assertThat(createdOrder).isNotNull();

		// Assert that values are stored correctly.
		java.sql.Date todaysDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		assertThat(createdOrder.getOrderDate()).isCloseTo(todaysDate, 500);
		assertThat(createdOrder.getId()).isNotNull();
		assertThat(createdOrder.getDeliveryAddress()).isEqualTo(order.getDeliveryAddress());
		assertThat(createdOrder.getPaymentMethod()).isEqualTo(order.getPaymentMethod());
		assertThat(createdOrder.getStatus()).isEqualTo(order.getStatus());
		assertThat(createdOrder.getDeliveryDate()).isNull(); // Delivery date should be set when order has been delivered.

		List<OrderRow> createdOrderRow = createdOrder.getOrderRows();

		for(int i = 0; i < createdOrderRow.size(); i++) {
			createdOrderRow.get(i).setPrice(100); // The price value should be set by backend through the productId.
			
			assertThat(createdOrderRow.get(i).getPrice()).isEqualTo(orderRow.get(i).getPrice());
			assertThat(createdOrderRow.get(i).getQuantity()).isEqualTo(orderRow.get(i).getQuantity());
			assertThat(createdOrderRow.get(i).getOrderRowTotal()).isEqualTo(orderRow.get(i).getOrderRowTotal());
		}

		// Retrieve order.
		OrderResponse storedOrderResponse = controller.getOrderById(createdOrder.getId());
		Order storedOrder = mapper.orderResponseToOrder(storedOrderResponse);

		assertThat(storedOrder).isNotNull();
	}

	@Test
	public void updateOrder() throws Exception {
		Order order = getTestOrder();

		// Create order.
		OrderRequest request = mapper.orderToOrderRequest(order);
		OrderResponse createdOrderResponse = controller.createOrder(request);
		Order createdOrder = mapper.orderResponseToOrder(createdOrderResponse);

		// Update order.
		createdOrder.setDeliveryAddress("New Delivery Address");
		OrderRequest updateOrderRequest = mapper.orderToOrderRequest(createdOrder);
		OrderResponse updatedOrderResponse = controller.updateOrder(updateOrderRequest, createdOrder.getId());
		Order updatedOrder = mapper.orderResponseToOrder(updatedOrderResponse);

		assertThat(createdOrder.getDeliveryAddress()).isEqualTo(updatedOrder.getDeliveryAddress());
	}
	
	@Test
	public void deleteOrder() throws Exception {
		Order order = getTestOrder();

		// Create order.
		OrderRequest request = mapper.orderToOrderRequest(order);
		OrderResponse createdOrder = controller.createOrder(request);

		// Delete order.
		controller.deleteOrder(createdOrder.getId());

		// Attempt to retrieve deleted order.
		OrderResponse deletedOrder = controller.getOrderById(createdOrder.getId());

		assertThat(deletedOrder).isNull();
	}

}