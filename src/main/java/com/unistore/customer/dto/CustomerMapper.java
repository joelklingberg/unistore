package com.unistore.customer.dto;

import java.util.List;
import com.unistore.customer.Customer;
import com.unistore.customer.dto.request.CustomerRequest;
import com.unistore.customer.dto.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    // CreateCustomerRequest -> Customer
    Customer customerRequestToCustomer(CustomerRequest request);

    // Customer -> CreateCustomerRequest
    CustomerRequest customerToCustomerRequest(Customer customer);

    // Customer -> CustomerResponse
    CustomerResponse customerToCustomerResponse(Customer customer);

    // CustomerResponse -> Customer
    Customer customerResponseToCustomer(CustomerResponse response);

    // Customers -> CustomerResponses
    List<CustomerResponse> customersToCustomerResponses(List<Customer> customers);
}
