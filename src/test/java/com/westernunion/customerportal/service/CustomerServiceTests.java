package com.westernunion.customerportal.service;


import com.westernunion.customerportal.model.Customer;
import com.westernunion.customerportal.repository.CustomerRepository;
import com.westernunion.customerportal.service.impl.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {

        List<Customer> customers = new ArrayList<>();
        Customer john = new Customer();
        john.setId(1L);
        john.setName("John");
        john.setEmail("john@example.com");
        Customer alice = new Customer();
        alice.setId(2L);
        alice.setName("Alice");
        alice.setEmail("alice@example.com");
        customers.add(john);
        customers.add(alice);
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();

        assertEquals(2, result.size());
    }

    @Test
    void testGetCustomerById() {

        Customer john = new Customer();
        john.setId(1L);
        john.setName("John");
        john.setEmail("john@example.com");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(john));

        Optional<Customer> result = customerService.getCustomerById(1L);

        assertEquals(john, result.orElse(null));
    }

    @Test
    void testSaveCustomer() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setEmail("john@example.com");
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.createCustomer(customer);

        assertEquals(customer, result);
    }

    @Test
    void testDeleteCustomerById() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setEmail("john@example.com");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer()));
        doNothing().when(customerRepository).deleteById(1L);

        customerService.deleteCustomer(1L);

        verify(customerRepository, times(1)).deleteById(1L);
    }
}
