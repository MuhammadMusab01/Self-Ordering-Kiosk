package com.kiosk.self_ordering_kiosk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "deal_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "deal_group_menu_items",
            joinColumns = @JoinColumn(name = "deal_group_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private Set<MenuItem> menuItems;

    @Column(name = "name")
    private String name;

    @Column(name = "is_required")
    private Boolean isRequired = false;

    @Column(name = "min_limit")
    private Integer minLimit;

    @Column(name = "max_limit")
    private Integer maxLimit;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
