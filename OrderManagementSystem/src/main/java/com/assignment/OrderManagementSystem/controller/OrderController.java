package com.assignment.OrderManagementSystem.controller;

import com.assignment.OrderManagementSystem.entity.Order;
import com.assignment.OrderManagementSystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order currOrder = orderService.createOrder(order);
        return new ResponseEntity<>(currOrder, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order updatedOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId){

        Order order = orderService.findById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable("id")Long orderId){
        orderService.deleteById(orderId);
        return new ResponseEntity<>("Order deleted Successfully",HttpStatus.OK);
    }
}
