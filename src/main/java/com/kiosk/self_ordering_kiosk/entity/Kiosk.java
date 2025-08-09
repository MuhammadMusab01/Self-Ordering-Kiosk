package com.kiosk.self_ordering_kiosk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kiosk")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kiosk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @Column
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
}
