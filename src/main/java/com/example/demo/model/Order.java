package com.example.demo.model;

import com.example.demo.constant.OrderState;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    Set<Product> products = new HashSet<>();

    @Column(name = "updated_at" )
    private  Long updatedAt;

    @Column
    private OrderState state;

    @PrePersist
    private void init(){
        this.updatedAt = Instant.now().toEpochMilli();
        this.createdAt = Instant.now().toEpochMilli();
    }

    @PreUpdate
    private void update(){
        this.updatedAt = Instant.now().toEpochMilli();
    }

    public Order() {
    }

    public Order(Long id, Long createdAt, String user, Set<Product> products, Long updatedAt, OrderState state) {
        this.id = id;
        this.createdAt = createdAt;
        this.user = user;
        this.products = products;
        this.updatedAt = updatedAt;
        this.state = state;
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

    public Long getUpdatedAt() {return updatedAt; }

    public void setUpdatedAt(Long updatedAt) {this.updatedAt = updatedAt; }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
