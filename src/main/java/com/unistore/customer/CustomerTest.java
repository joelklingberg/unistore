package com.unistore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.unistore.customer.dto.CustomerMapperImpl;
import com.unistore.customer.dto.request.CustomerRequest;
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
		CustomerRequest createCustomerRequest = mapper.CustomerToCustomerRequest(customer);

		// Create customer.
		CustomerResponse response = controller.createCustomer(createCustomerRequest);
		Customer createdCustomer = mapper.CustomerResponseToCustomer(response);

		// Assert that values are stored correctly.
		assertThat(createdCustomer).isNotNull();
		assertThat(createdCustomer.getAddress()).isEqualTo(customer.getAddress());
		assertThat(createdCustomer.getEmail()).isEqualTo(customer.getEmail());
		assertThat(createdCustomer.getFullName()).isEqualTo(customer.getFullName());
		assertThat(createdCustomer.getPhoneNo()).isEqualTo(customer.getPhoneNo());

		// Retrieve customer.
		CustomerResponse storedCustomerResponse = controller.getCustomerById(createdCustomer.getId());
		Customer storedCustomer = mapper.CustomerResponseToCustomer(storedCustomerResponse);
		assertThat(storedCustomer).isNotNull();
	}

	@Test
	public void updateCustomer() throws Exception {

		// Create customer.
		Customer customer = getTestCustomer();
		CustomerRequest createCustomerRequest = mapper.CustomerToCustomerRequest(customer);
		CustomerResponse createCustomerResponse = controller.createCustomer(createCustomerRequest);
		Customer createdCustomer = mapper.CustomerResponseToCustomer(createCustomerResponse);
		
		// Update customer.
		createdCustomer.setFullName("Customer New Name");
		CustomerRequest updateRequest = mapper.CustomerToCustomerRequest(createdCustomer);
		CustomerResponse updateResponse = controller.updateCustomer(updateRequest, createdCustomer.getId());
		Customer updatedCustomer = mapper.CustomerResponseToCustomer(updateResponse);

		assertThat(createdCustomer.getFullName()).isEqualTo(updatedCustomer.getFullName());
	}
	
	@Test
	public void deleteCustomer() throws Exception {
		Customer customer = getTestCustomer();
		CustomerRequest createCustomerRequest = mapper.CustomerToCustomerRequest(customer);

		// Create customer.
		CustomerResponse response = controller.createCustomer(createCustomerRequest);
		Customer createdCustomer = mapper.CustomerResponseToCustomer(response);

		// Delete customer.
		controller.deleteCustomer(createdCustomer.getId());

		// Attempt to retrieve deleted customer.
		CustomerResponse deletedCustomer = controller.getCustomerById(createdCustomer.getId());

		assertThat(deletedCustomer).isNull();
	}

}