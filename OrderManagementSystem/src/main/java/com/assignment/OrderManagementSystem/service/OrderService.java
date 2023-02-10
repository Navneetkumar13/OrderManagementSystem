package com.assignment.OrderManagementSystem.service;

import com.assignment.OrderManagementSystem.entity.Order;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);
    public Order findById(Long id);
    public List<Order> getAllOrders();
    public void deleteById(Long orderId);
    public Order updateOrder(Order order);
}
