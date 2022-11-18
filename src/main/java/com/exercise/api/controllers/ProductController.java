package com.exercise.api.controllers;

import com.exercise.api.entities.dtos.CreateProductDto;
import com.exercise.api.entities.dtos.UpdateStockDto;
import com.exercise.api.entities.Product;
import com.exercise.api.exceptions.NotFoundException;
import com.exercise.api.services.IProductService;
import com.exercise.api.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto createProductDto) {
        LOG.info(">>> Creating product: " + createProductDto.toString());
        try {
            Product productCreated = productService.addProduct(createProductDto);
            return new ResponseEntity<Product>(productCreated, null, 200);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> createMultipleProducts (@RequestBody List<CreateProductDto> createProductDtoList) {
        LOG.info(">>> Creating multiple products: " + createProductDtoList.toString());
        try {
            List<Product> productsCreated = productService.addMultipleProducts(createProductDtoList);
            return new ResponseEntity<List<Product>>(productsCreated, null, 200);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        LOG.info(">>> Getting product with id: " + id);
        try {
            Product product = productService.getProductById(id);
            return new ResponseEntity<Product>(product, null, 200);
        } catch (NotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        LOG.info("Getting all products");
        try {
            return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStock(@PathVariable Long id, @RequestBody UpdateStockDto updateStockDto) {
        LOG.info("Updating stock for product with id: " + id);
        try {
            Product product = productService.updateStock(id, updateStockDto.getStock());
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        LOG.info("Deleting product with id: " + id);
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
