package com.xpanxion.restproject.controller;

import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.repository.CustomerRepository;
import com.xpanxion.restproject.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class CustomerController
{
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customer> listCustomers()
    {
        return this.customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer viewCustomer(@PathVariable Long id)
    {
        //return this.customerRepository.findById(id).get();
        return this.customerService.getCustomer(id);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return this.customerService.createCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customerInput, @PathVariable(value = "id") Long id)
    {
        return this.customerService.updateCustomer(customerInput, id);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable(value = "id") Long id)
    {
        return this.customerService.deleteCustomer(id);
    }

    // Custom Queries
    @GetMapping("/customer/lastname")
    public List<Customer> getByLastName(@RequestParam String lastName)
    {
        return this.customerService.getCustomerByLastName(lastName);
    }

    @GetMapping("customer/firstname")
    public List<Customer> getByFirstNameNative(@RequestParam String firstName)
    {
        return this.customerService.getCustomerByFirstName(firstName);
    }


}
