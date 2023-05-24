package com.codeup.codeupspringblog.product.repository;

import com.codeup.codeupspringblog.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
}
