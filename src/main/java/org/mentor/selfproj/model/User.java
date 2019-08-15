package org.mentor.selfproj.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = false, updatable = false)
    private String name;

    @Column(name = "password", updatable = false)
    private String password;

    @Column(name = "role", updatable = false)
    private String role;

    public User() {
    }

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.password = role;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    } //Long

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

}
