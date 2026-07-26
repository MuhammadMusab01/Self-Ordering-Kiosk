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

    @Column(name = "order_no")
    private String orderNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "kiosk_id")
    private Integer kioskId;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_tip")
    private Double orderTip;

    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "special_instructions")
    private String specialInstructions;

    @Column(name = "serving_time")
    private Integer servingTime;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        orderDate = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
