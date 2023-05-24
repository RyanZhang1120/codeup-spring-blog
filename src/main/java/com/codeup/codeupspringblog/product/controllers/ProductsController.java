package com.codeup.codeupspringblog.product.controllers;

import com.codeup.codeupspringblog.product.models.Category;
import com.codeup.codeupspringblog.product.models.Product;
import com.codeup.codeupspringblog.product.repository.CategoriesRepository;
import com.codeup.codeupspringblog.product.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsController {

    private final ProductRepository productDao;
    private final CategoriesRepository categoryDao;

    public ProductsController(ProductRepository productDao, CategoriesRepository categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }


    @GetMapping("/products/index")
    public String productsIndex(Model model){
//        // Create new Category instances
//        Category category1 = new Category();
//        category1.setName("track infrastructure");
//
//        Category category2 = new Category();
//        category2.setName("Category 2");
//
//        Category category3 = new Category();
//        category3.setName("Category 3");
//
//        Category category4 = new Category();
//        category4.setName("go kart");
//
//        Category category5 = new Category();
//        category5.setName("for pets");
//
//        // Save the categories
//        categoryDao.save(category1);
//        categoryDao.save(category2);
//        categoryDao.save(category3);
//        categoryDao.save(category4);
//        categoryDao.save(category5);
//
        List<Product> products = productDao.findAll();
//
////        Off the cuff adding new product example
//
//        //Remember the name of the game is WHAT BUILDS RELATIONSHIPS - Objects do ORM ~ ~ ~
//        //I need to RELATE a product object TO a number of category
//
////        //1. Let me set up a new product.. 2. let me get a list of all of my categories
//       Product testAdd = new Product();
//       List<Category> myCategories = categoryDao.findAll();
////
////        //Three category objects that I want to RELATE to my ONE PRODUCT object id 0 = track infrastructure, id 3 = go kart, id 4 = for pets
//      Category oneCategory = myCategories.get(4);
//      Category twoCategory = myCategories.get(3);
//      Category threeCategory = myCategories.get(0);
////
////      //Product needs a NAME and a PRICE, right?
//       testAdd.setName("amazing cat go kart track");
//       testAdd.setPrice(9999.99);
////
////       //I'm setting up a LIST for my product object to use with the setter
//       List<Category> forMyNewProduct = new ArrayList<>();
////
////       //Adding all the relevant categories to the list for the new product
//       forMyNewProduct.add(oneCategory);
//       forMyNewProduct.add(twoCategory);
//       forMyNewProduct.add(threeCategory);
////
////       //Product object > here's the LIST OF CATEGORY OBJECTS to SET to yourself
//       testAdd.setProductCategories(forMyNewProduct);
////
////       //Product object, now go and PERSIST into the database with those categories objects assigned to you
//       productDao.save(testAdd);

        model.addAttribute("productsList", products);
        return "products/productIndex";
    }
}
