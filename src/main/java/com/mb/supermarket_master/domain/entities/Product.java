package com.mb.supermarket_master.domain.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(name="CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Column
    private int stock;
}
