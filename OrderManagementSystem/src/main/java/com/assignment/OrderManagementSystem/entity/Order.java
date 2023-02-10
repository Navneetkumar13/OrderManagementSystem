package com.assignment.OrderManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order_id")
    private Long orderId;

    @Column(name = "item")
    private String itemName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

//    @OneToOne
//    @JoinColumn(name = "user_id")
    private Long user_id;

//    @Transient
//    private Long user_id;

}
