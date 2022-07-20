package com.xpanxion.restproject.controller;

import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController
{

    private CustomerRepository customerRepository;


    // Constructor
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CRUD -
    // Create, @PostMapping
    // Read, - @GetMapping
    // Update  @PutMapping,
    //         @PatchMapping - specific fields
    // Delete  @DeleteMapping

    @GetMapping("/customers")
    public List<Customer> listCustomers()
    {
        return this.customerRepository.findAll();
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return this.customerRepository.save(customer);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customerInput, @PathVariable(value = "id") Long id)
    {
        Customer customer = this.customerRepository.findById(id).get();
        customer.setFirstName(customerInput.getFirstName());
        customer.setLastName(customerInput.getLastName());
        return this.customerRepository.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Long id)
    {
        this.customerRepository.deleteById(id);
    }


}
