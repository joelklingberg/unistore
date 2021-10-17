package com.unistore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.unistore.customer.dto.CustomerMapperImpl;
import com.unistore.customer.dto.request.CustomerRequest;
import com.unistore.customer.dto.response.CustomerResponse;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapperImpl mapper;

    @Autowired
    public CustomerController(CustomerService service, CustomerMapperImpl mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = service.getAllCustomers();
        return mapper.customersToCustomerResponses(customers);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id) {
        Customer customer = service.getCustomerById(id);
        return mapper.customerToCustomerResponse(customer);
    }

    @PostMapping()
    public CustomerResponse createCustomer(@RequestBody CustomerRequest request) {
        Customer customer = mapper.customerRequestToCustomer(request);
        Customer createdCustomer = service.createCustomer(customer);
        return mapper.customerToCustomerResponse(createdCustomer);
    }
    
    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(
        @RequestBody CustomerRequest request,
        @PathVariable Long id
    ) {
        Customer customerToUpdate = mapper.customerRequestToCustomer(request);
        Customer updatedCustomer = service.updateCustomer(id, customerToUpdate);
        return mapper.customerToCustomerResponse(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

}
