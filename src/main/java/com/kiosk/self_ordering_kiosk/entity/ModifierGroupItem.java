package com.kiosk.self_ordering_kiosk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modifier_groups_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifierGroupItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_item_id")
    private Integer menuItemId;

    @Column(name = "price")
    private Double price;

    @Column(name = "modifier_group_id")
    private Integer modifierGroupId;

}
