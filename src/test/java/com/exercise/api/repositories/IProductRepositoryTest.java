package com.exercise.api.repositories;

import com.exercise.api.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IProductRepositoryTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    public void saveProduct() {

        Product product = new Product();
        product.setName("Test Product 3");
        product.setPrice(150.50);
        product.setStock(10);

        productRepository.save(product);
    }

    @Test
    public void findAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        System.out.println(">>> Products: " + products);
    }

    @Test
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}