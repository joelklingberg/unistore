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
import com.unistore.customer.dto.request.CreateCustomerRequest;
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
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping()
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        Customer customer = mapper.CreateCustomerRequestToCustomer(request);
        Customer createdCustomer = service.createCustomer(customer);
        CustomerResponse response = mapper.CustomerToCustomerResponse(createdCustomer);
        return response;
    }
    
    @PutMapping("/{id}")
    public Customer updateCustomer(
        @RequestBody Customer updatedCustomer,
        @PathVariable Long id
    ) {
        return service.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

}
