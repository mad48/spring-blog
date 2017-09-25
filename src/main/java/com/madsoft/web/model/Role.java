package com.madsoft.web.model;

import javax.persistence.*;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_roles")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id", unique = true, nullable = false)
    private Integer id;


    @Column(name = "username", unique = true, length = 50) // unique = true,nullable = false,
    @Size(min = 3, max = 50)
    private String username;

    @Column(name = "role", length = 50)//nullable = false,
    @NotEmpty
    private String role;


    public Role() {
    }

    public Role(String username, String role) {
        this.username = username;
        this.role = role;
    }


    public Integer getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
