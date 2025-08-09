package com.kiosk.self_ordering_kiosk.entity;

import com.kiosk.self_ordering_kiosk.enums.ModifierType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Set;

@Entity
@Table(name = "modifier_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifierGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "modifier_type", nullable = false)
    private ModifierType modifierTypeId;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "menu_item_modifier_group",
            joinColumns = @JoinColumn(name = "modifier_group_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private Set<MenuItems> menuItems;

    private Boolean isRequired = false;

    private Integer minLimit;

    private Integer maxLimit;

    private Boolean isAvailable;

}
