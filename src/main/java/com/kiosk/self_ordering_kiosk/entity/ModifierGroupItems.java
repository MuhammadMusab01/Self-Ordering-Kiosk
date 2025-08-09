package com.kiosk.self_ordering_kiosk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "modifier_groups_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifierGroupItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer menuItemId;

    private Double price;

    private Integer modifierGroupId;

}
