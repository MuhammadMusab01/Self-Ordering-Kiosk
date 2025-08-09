package com.kiosk.self_ordering_kiosk.entity;

import com.kiosk.self_ordering_kiosk.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNo;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status;

    private LocalDateTime orderDate;

    private Integer kioskId;

    private Double totalPrice;

    private Double orderTip;

    private Integer paymentId;

    private String specialInstructions;

    private Integer servingTime;
}
