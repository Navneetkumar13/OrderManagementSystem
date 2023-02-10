package com.assignment.OrderManagementSystem.service.implementation;

import com.assignment.OrderManagementSystem.entity.User;
import com.assignment.OrderManagementSystem.entity.UserType;
import com.assignment.OrderManagementSystem.repository.OrderRepository;
import com.assignment.OrderManagementSystem.repository.UserRepository;
import com.assignment.OrderManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user){
        User createdUser = userRepository.save(user);
        createdUser.setType(UserType.REGULAR);
        return createdUser;
    }

    @Override
    public User updateUser(User user){
        User currUser = userRepository.findById(user.getId()).get();
        currUser.setName(user.getName());
        currUser.setEmail(user.getEmail());
        return currUser;
    }

    @Override
    public User getUserById(Long userId){

        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers(){

        List<User> list = userRepository.findAll();
        return list;
    }
}
