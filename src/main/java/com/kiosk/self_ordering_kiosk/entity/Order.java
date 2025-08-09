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

    @Column(nullable = false)
    private String orderNo;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status;

    @Column
    private LocalDateTime orderDate;

    @Column
    private Integer kioskId;

    @Column
    private Double totalPrice;

    @Column
    private Double orderTip;

    @Column
    private Integer paymentId;

    @Column
    private String specialInstructions;

    @Column
    private Integer servingTime;
}
