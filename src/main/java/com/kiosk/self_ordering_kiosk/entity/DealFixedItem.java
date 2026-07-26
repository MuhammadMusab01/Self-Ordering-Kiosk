package com.kiosk.self_ordering_kiosk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deal_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealFixedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_id")
    private Integer deal_id;

    @Column(name = "menu_item_id")
    private Integer menuItemId;

    @Column(name = "quantity")
    private Integer quantity;
}
