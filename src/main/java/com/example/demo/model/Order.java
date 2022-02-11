package com.example.demo.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at")
    private Long createdAt;

    @Column
    private String user;

    @ManyToMany(mappedBy = "orders")
    Set<Product> products = new HashSet<>();

    @Column(name = "updated_at" )
    private  Long updatedAt;

    @Column
    private  String state;

    @PrePersist
    private void init(){
        this.updatedAt = Instant.now().toEpochMilli();
        this.createdAt = Instant.now().toEpochMilli();
    }

    @PreUpdate
    private void update(){
        this.updatedAt = Instant.now().toEpochMilli();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<Product> getListProducts() {
        return products;
    }

    public void setListProducts(Set<Product> products) {
        this.products = products;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
