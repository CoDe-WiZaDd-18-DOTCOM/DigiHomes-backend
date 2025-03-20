package com.example.DigiHomes.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String authid;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "users_id")
    private List<Properties> property;

    public List<Properties> getProperty() {
        return property;
    }

    public void setProperty(List<Properties> property) {
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthid() {
        return authid;
    }

    public void setAuthid(String authid) {
        this.authid = authid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
