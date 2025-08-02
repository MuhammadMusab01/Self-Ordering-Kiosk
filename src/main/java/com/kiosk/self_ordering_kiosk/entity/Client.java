package com.kiosk.self_ordering_kiosk.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Client name is required")
    @Size(max = 100)
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer totalBranches;

    @Size(max = 100)
    private String contactPerson;

    @Size(max = 100)
    private String email;

    @Size(max = 15)
    private String phone;

    @Size(max = 255)
    private String address;

    private boolean active = true;
}
