package com.kiosk.self_ordering_kiosk.entity;

import com.kiosk.self_ordering_kiosk.enums.BranchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Integer activeKiosk;

    @Column
    private Boolean isActive;

    @Column(name = "opening_time", nullable = false)
    private LocalTime openingTime;

    @Column(name = "closing_time", nullable = false)
    private LocalTime closingTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BranchStatus status;

}
