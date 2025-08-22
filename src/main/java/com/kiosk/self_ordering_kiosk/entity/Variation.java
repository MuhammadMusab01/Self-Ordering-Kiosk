package com.kiosk.self_ordering_kiosk.entity;
import com.kiosk.self_ordering_kiosk.enums.VariationName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "variations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Variation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private VariationName name;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;
}
