package com.example.DigiHomes.entities;

import jakarta.persistence.*;

@Entity
@Table(name="facilities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"bedrooms","parkings","bathrooms"})})
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private int bedrooms;

    @Column(nullable = false)
    private int parkings;

    @Column(nullable = false)
    private int bathrooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getParkings() {
        return parkings;
    }

    public void setParkings(int parkings) {
        this.parkings = parkings;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }
}
