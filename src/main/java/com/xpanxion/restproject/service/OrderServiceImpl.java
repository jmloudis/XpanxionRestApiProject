package com.xpanxion.restproject.service;

import com.xpanxion.restproject.model.Customer;
import com.xpanxion.restproject.model.Order;
import com.xpanxion.restproject.repository.CustomerRepository;
import com.xpanxion.restproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Order> getAllOrders()
    {
        return this.orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId)
    {
        return this.orderRepository.findByCustomerId(customerId);
    }


    @Override
    public Order createOrder(Long customerId, Order order)
    {
        Customer customer = this.customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        return this.orderRepository.save(order);

    }

    @Override
    public Order updateOrderById(Long orderId, Order orderInput)
    {
        Order order = this.orderRepository.findById(orderId).get();
        order.setOrderDate(orderInput.getOrderDate());
        order.setDescription(orderInput.getDescription());
        return this.orderRepository.save(order);
    }

    @Override
    public ResponseEntity<Long> deleteOrderById(Long orderId)
    {
        this.orderRepository.deleteById(orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
