package com.codeup.codeupspringblog.product.repository;

import com.codeup.codeupspringblog.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
