package com.example.DigiHomes.entities;

import jakarta.persistence.*;

@Entity
@Table(name="properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "locations_id",nullable = false)
    private Locations location;

    @ManyToOne
    @JoinColumn(name = "facilities_id",nullable = false)
    private Facilities facility;
}
