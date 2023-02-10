package com.assignment.OrderManagementSystem.service;

import com.assignment.OrderManagementSystem.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User updateUser(User user);
    public User getUserById(Long userid);
    public List<User> getAllUsers();
    public void deleteUserById(Long userId);
}
