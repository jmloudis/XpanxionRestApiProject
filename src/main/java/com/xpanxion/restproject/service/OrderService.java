package com.xpanxion.restproject.service;

import com.xpanxion.restproject.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService
{
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomerId(Long CustomerId);
    Order createOrder(Long customerId, Order order);
    Order updateOrderById(Long orderId, Order orderInput);
    ResponseEntity<Long> deleteOrderById(Long orderId);
}
