package com.codeup.codeupspringblog.product.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToMany(mappedBy = "productCategories")
    private List<com.codeup.codeupspringblog.product.models.Product> products;

    public Category() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<com.codeup.codeupspringblog.product.models.Product> getProducts() {
        return products;
    }

    public void setProducts(List<com.codeup.codeupspringblog.product.models.Product> products) {
        this.products = products;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
