package com.unistore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        try {
            return customerRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer newCustomer) {
        Customer oldCustomer = customerRepository.findById(id).get();

        if(oldCustomer != null) {
            newCustomer.setId(id);
            return customerRepository.save(newCustomer);
        }

        return null;
    }

}
