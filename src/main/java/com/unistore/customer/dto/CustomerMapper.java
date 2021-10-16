package com.unistore.customer.dto;

import java.util.List;

import com.unistore.customer.Customer;
import com.unistore.customer.dto.request.CustomerRequest;
import com.unistore.customer.dto.response.CustomerResponse;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    // CreateCustomerRequest -> Customer
    Customer CustomerRequestToCustomer(CustomerRequest createCustomerRequest);

    // Customer -> CreateCustomerRequest
    CustomerRequest CustomerToCustomerRequest(Customer customer);

    // Customer -> CustomerResponse
    CustomerResponse CustomerToCustomerResponse(Customer customer);

    // CustomerResponse -> Customer
    Customer CustomerResponseToCustomer(CustomerResponse response);

    // Customers -> CustomerResponses
    List<CustomerResponse> CustomersToCustomerResponses(List<Customer> customers);
}
