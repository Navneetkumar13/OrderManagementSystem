package com.assignment.OrderManagementSystem.repository;

import com.assignment.OrderManagementSystem.entity.Order;
import com.assignment.OrderManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "SELECT count(*) FROM orders WHERE user_id = :userId",nativeQuery = true)
    public int findOrderCountByUserId(@Param(value = "userId") Long userId);
}
