package com.xpanxion.restproject.service;

import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return this.customerRepository.findById(customerId).get();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer customerUpdate = this.customerRepository.findById(customerId).get();
        customerUpdate.setFirstName(customer.getFirstName());
        customerUpdate.setLastName(customer.getLastName());
        return this.customerRepository.save(customerUpdate);
    }

    @Override
    public ResponseEntity<Long> deleteCustomer(Long customerId) {
        this.customerRepository.deleteById(customerId);
        return new ResponseEntity<>(customerId, HttpStatus.OK);
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) {
        return this.customerRepository.findByFirstNameNative(firstName);
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {
        return this.customerRepository.findByLastName(lastName);
    }
}
