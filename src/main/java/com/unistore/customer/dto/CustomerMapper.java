package com.unistore.customer.dto;

import com.unistore.customer.Customer;
import com.unistore.customer.dto.request.CreateCustomerRequest;
import com.unistore.customer.dto.response.CustomerResponse;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    // CreateCustomerRequest -> Customer
    Customer CreateCustomerRequestToCustomer(CreateCustomerRequest createCustomerRequest);

    // Customer -> CreateCustomerRequest
    CreateCustomerRequest CustomerToCreateCustomerRequest(Customer customer);

    // Customer -> CustomerResponse
    CustomerResponse CustomerToCustomerResponse(Customer customer);

    // CustomerResponse -> Customer
    Customer CustomerResponseToCustomer(CustomerResponse response);
}
