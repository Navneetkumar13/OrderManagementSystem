package com.assignment.OrderManagementSystem.repository;

import com.assignment.OrderManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.springframework.stereotype.Repository;
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findUserForCronJob();
}
