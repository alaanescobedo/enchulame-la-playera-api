package com.exercise.api.controllers;

import com.exercise.api.entities.ProductCategory;
import com.exercise.api.services.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-category")
@CrossOrigin(origins = "*")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody ProductCategory productCategory) {
        try {
            productCategoryService.addProductCategory(productCategory);
            return new ResponseEntity<ProductCategory>(productCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(productCategoryService.getAllProductCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
