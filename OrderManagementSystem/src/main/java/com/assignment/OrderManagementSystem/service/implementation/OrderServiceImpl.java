package com.assignment.OrderManagementSystem.service.implementation;

import com.assignment.OrderManagementSystem.entity.Order;
import com.assignment.OrderManagementSystem.entity.User;
import com.assignment.OrderManagementSystem.entity.UserType;
import com.assignment.OrderManagementSystem.repository.OrderRepository;
import com.assignment.OrderManagementSystem.repository.UserRepository;
import com.assignment.OrderManagementSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    void sendGoldMail() {
        System.out.println("You have placed 9 orders with us. Buy one more stuff and you will be promoted to Gold customer");
    }
    void sendPlatinumMail() {
        System.out.println("You have placed 9 orders with us. Buy one more stuff and you will be promoted to Platinum customer");
    }
    @Override
    public Order createOrder(Order order) {
        if(orderRepository.findOrderCountByUserId(order.getUser_id()) == 9){
            sendGoldMail();
        }
        if(orderRepository.findOrderCountByUserId(order.getUser_id()) == 19){
            sendPlatinumMail();
        }
        // Discount Condition checking and storing values as per the specified conditions.
        if(((Integer)orderRepository.findOrderCountByUserId(order.getUser_id())  == null)){
            User user = userRepository.findById(order.getUser_id()).get();
            user.setType(UserType.REGULAR);
            user.setDiscount(0);
        }
        if(orderRepository.findOrderCountByUserId(order.getUser_id())<10){
            User user = userRepository.findById(order.getUser_id()).get();
            user.setType(UserType.REGULAR);
            user.setDiscount(0);
        }
        if(orderRepository.findOrderCountByUserId(order.getUser_id())<20 && orderRepository.findOrderCountByUserId(order.getUser_id())>=10){
            User user = userRepository.findById(order.getUser_id()).get();
            user.setType(UserType.GOLD);
            user.setDiscount(10);
        }
        if(orderRepository.findOrderCountByUserId(order.getUser_id())>=20 ){
            User user = userRepository.findById(order.getUser_id()).get();
            user.setType(UserType.PLATINUM);
            user.setDiscount(20);
        }
//        User user = userRepository.findById(order.getUser_id()).get();
//        order.setUser(user);
        Order createdOrder = orderRepository.save(order);
        return createdOrder;
    }

    @Override
    public Order findById(Long orderId) {
        //System.out.println(orderRepository.findOrderCountByUserId((long) 1));
        Optional<Order> user = orderRepository.findById(orderId);
        return user.get();
    }

    @Override
    public void deleteById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrder(Order order) {
        Order currOrder = orderRepository.findById(order.getOrderId()).get();
        currOrder.setQuantity(order.getQuantity());
        currOrder.setItemName(order.getItemName());
        currOrder.setUser_id(order.getUser_id());
        return currOrder;
    }

    @Override
    public List<Order> getAllOrders(){
        List<Order> list = orderRepository.findAll();
        return list;
    }

}
