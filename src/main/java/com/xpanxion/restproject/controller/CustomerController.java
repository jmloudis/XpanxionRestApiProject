package com.xpanxion.restproject.controller;

import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class CustomerController
{

    private CustomerRepository customerRepository;


    // Constructor Dependency Injection
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CRUD -
    // Create, @PostMapping
    // Read, - @GetMapping
    // Update  @PutMapping,
    //         @PatchMapping - specific fields
    // Delete  @DeleteMapping

    @GetMapping("/customer")
    public List<Customer> listCustomers()
    {
        return this.customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer viewCustomer(@PathVariable Long id)
    {
        return this.customerRepository.findById(id).get();
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return this.customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customerInput, @PathVariable(value = "id") Long id)
    {
        Customer customer = this.customerRepository.findById(id).get();
        customer.setFirstName(customerInput.getFirstName());
        customer.setLastName(customerInput.getLastName());
        return this.customerRepository.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Long id)
    {
        this.customerRepository.deleteById(id);
    }

    // Custom Queries
    @GetMapping("/customers/lastname/{lastName}")
    public List<Customer> getByLastName(@PathVariable String lastName)
    {
        return this.customerRepository.findByLastName(lastName);
    }


}
