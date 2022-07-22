package com.xpanxion.restproject.service;

import com.xpanxion.restproject.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService
{
    List<Customer> getAllCustomers();
    Customer getCustomer(Long customerId);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Long customerId);
    ResponseEntity<Long> deleteCustomer(Long customerId);
    List<Customer> getCustomerByFirstName(String firstName);
    List<Customer> getCustomerByLastName(String lastName);

}
