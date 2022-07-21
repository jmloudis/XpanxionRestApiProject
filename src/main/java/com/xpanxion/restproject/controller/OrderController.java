package com.xpanxion.restproject.controller;


import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.model.Order;
import com.xpanxion.restproject.repository.CustomerRepository;
import com.xpanxion.restproject.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class OrderController
{
    private OrderRepository orderRepository;

    private CustomerRepository customerRepository;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/order")
    public List<Order> orderList()
    {
        return this.orderRepository.findAll();
    }

    @PostMapping("/customer/{customerId}/order")
    public Order createOrder(@PathVariable Long customerId, @RequestBody Order order)
    {
        Customer customer = this.customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    @GetMapping("/customer/{customerId}/order")
    public List<Order> listByCustomerId(@PathVariable Long customerId)
    {
        return this.orderRepository.findByCustomerId(customerId);
    }

    @DeleteMapping("/order/{id}")
    public String deleteCourse(@PathVariable(name = "id") Long orderId)
    {
        this.orderRepository.deleteById(orderId);
        return "Item " + orderId + " Deleted";
    }



}
