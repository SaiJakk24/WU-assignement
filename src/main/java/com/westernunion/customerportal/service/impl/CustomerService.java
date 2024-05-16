package com.westernunion.customerportal.service.impl;

//import com.westernunion.customerportal.exception.ResourceNotFoundException;
import com.westernunion.customerportal.exception.ResourceNotFoundException;
import com.westernunion.customerportal.model.Customer;
import com.westernunion.customerportal.repository.CustomerRepository;
import com.westernunion.customerportal.utiility.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Validations validations;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new ResourceNotFoundException(id);
        }
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) { return customerRepository.save(customer); }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setAddress(customerDetails.getAddress());
            customer.setPhoneNumber(customerDetails.getPhoneNumber());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            return customerRepository.save(customer);
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    public void deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}

