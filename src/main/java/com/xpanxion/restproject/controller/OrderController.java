package com.xpanxion.restproject.controller;


import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.model.Order;
import com.xpanxion.restproject.repository.CustomerRepository;
import com.xpanxion.restproject.repository.OrderRepository;
import com.xpanxion.restproject.service.OrderService;
import com.xpanxion.restproject.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class OrderController
{

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/order")
    public List<Order> orderList()
    {
        return this.orderService.getAllOrders();
    }

    @PostMapping("/customer/{customerId}/order")
    public Order createOrder(@PathVariable Long customerId, @RequestBody Order order)
    {
        return this.orderService.createOrder(customerId, order);
    }

    @GetMapping("/customer/{customerId}/order")
    public List<Order> listByCustomerId(@PathVariable Long customerId)
    {
        return this.orderService.getOrdersByCustomerId(customerId);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable(name = "id") Long orderId)
    {
        return this.orderService.deleteOrderById(orderId);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable(name = "id") Long orderId, @RequestBody Order order)
    {
        return this.orderService.updateOrderById(orderId, order);
    }



}
