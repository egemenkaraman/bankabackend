package com.example.stajbank;

import javax.persistence.*;

@Entity
@Table(name ="STAJBANKLOGINUSERS")
public class loginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Default constructor
    public loginEntity() {
    }

    // Parameterized constructor
    public loginEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

