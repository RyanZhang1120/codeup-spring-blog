package com.codeup.codeupspringblog.product.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column
    private double price;

    @ManyToMany
    @JoinTable(
            name="products_categories",
            joinColumns={@JoinColumn(name="product_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> productCategories;

    public Product() {
    }

    //Reading from the database (bring the ID with you too plz)
    public Product(Long id, String name, double price, List<Category> productCategories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productCategories = productCategories;
    }


    //Database insertion constructor
    public Product(String name, double price, List<Category> productCategories) {
        this.name = name;
        this.price = price;
        this.productCategories = productCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Category> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<Category> productCategories) {
        this.productCategories = productCategories;
    }
}
