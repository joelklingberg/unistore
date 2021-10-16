package com.unistore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.unistore.customer.dto.CustomerMapperImpl;
import com.unistore.customer.dto.request.CreateCustomerRequest;
import com.unistore.customer.dto.response.CustomerResponse;

import static com.unistore.core.configuration.TestConfig.TEST_PROPERTY_SOURCE;

@SpringBootTest
@TestPropertySource(locations = TEST_PROPERTY_SOURCE)
public class CustomerTest {

	@Autowired
	private CustomerController controller;

	@Autowired
	private CustomerMapperImpl mapper;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	private Customer getTestCustomer() {
		Customer customer = new Customer();

		customer.setAddress("Test address");
		customer.setEmail("test@email.com");
		customer.setFullName("Test Name");
		customer.setPhoneNo("1234567890");

		return customer;
	}

	@Test
	public void createCustomer() throws Exception {
		Customer customer = getTestCustomer();
		CreateCustomerRequest request = mapper.CustomerToCreateCustomerRequest(customer);

		// Create customer.
		CustomerResponse response = controller.createCustomer(request);
		Customer createdCustomer = mapper.CustomerResponseToCustomer(response);

		// Assert that values are stored correctly.
		assertThat(createdCustomer).isNotNull();
		assertThat(createdCustomer.getAddress()).isEqualTo(customer.getAddress());
		assertThat(createdCustomer.getEmail()).isEqualTo(customer.getEmail());
		assertThat(createdCustomer.getFullName()).isEqualTo(customer.getFullName());
		assertThat(createdCustomer.getPhoneNo()).isEqualTo(customer.getPhoneNo());

		// Retrieve customer.
		Customer storedCustomer = controller.getCustomerById(createdCustomer.getId());
		assertThat(storedCustomer).isNotNull();
	}

	@Test
	public void updateCustomer() throws Exception {
		Customer customer = getTestCustomer();
		CreateCustomerRequest request = mapper.CustomerToCreateCustomerRequest(customer);

		// Create customer.
		CustomerResponse response = controller.createCustomer(request);
		Customer createdCustomer = mapper.CustomerResponseToCustomer(response);

		// Update customer.
		createdCustomer.setFullName("Customer New Name");
		Customer updatedCustomer = controller.updateCustomer(createdCustomer, createdCustomer.getId());

		assertThat(createdCustomer.getFullName()).isEqualTo(updatedCustomer.getFullName());
	}
	
	@Test
	public void deleteCustomer() throws Exception {
		Customer customer = getTestCustomer();
		CreateCustomerRequest request = mapper.CustomerToCreateCustomerRequest(customer);

		// Create customer.
		CustomerResponse response = controller.createCustomer(request);
		Customer createdCustomer = mapper.CustomerResponseToCustomer(response);

		// Delete customer.
		controller.deleteCustomer(createdCustomer.getId());

		// Attempt to retrieve deleted customer.
		Customer deletedCustomer = controller.getCustomerById(createdCustomer.getId());

		assertThat(deletedCustomer).isNull();
	}

}