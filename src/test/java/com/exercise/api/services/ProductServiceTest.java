package com.exercise.api.services;

import com.exercise.api.entities.Color;
import com.exercise.api.entities.Product;
import com.exercise.api.entities.ProductCategory;
import com.exercise.api.entities.Size;
import com.exercise.api.repositories.IColorRepository;
import com.exercise.api.repositories.IProductCategoryRepository;
import com.exercise.api.repositories.IProductRepository;
import com.exercise.api.repositories.ISizeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductServiceTest {

    @Autowired
    private IProductRepository repository;
    @Autowired
    private IColorRepository colorRepository;
    @Autowired
    private ISizeRepository sizeRepository;
    @Autowired
    private IProductCategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    private Product product;

    private Color color;
    private Size size;
    private ProductCategory category;

    @BeforeEach
    void setUp() {
        color = new Color();
        color.setId(1L);
        color.setName("Blue");
        colorRepository.save(color);

        size = new Size();
        size.setId(1L);
        size.setName("M");
        sizeRepository.save(size);

        category = new ProductCategory();
        category.setId(1L);
        category.setName("Category 1");
        categoryRepository.save(category);

        product = new Product();
        product.setId(1L);
        product.setName("Product 1");
        product.setPrice(100.50);
        product.setStock(10);
        product.setImage("image.jpg");
        product.setColors(List.of(color));
        product.setSizes(List.of(size));
        product.setCategory(category);

        repository.save(product);
    }

    @Test
    void addProduct() {

        Product product1 = new Product();
        product1.setId(2L);
        product1.setName("Product 2");
        product1.setImage("image.jpg");
        product1.setPrice(200.30);
        product1.setColors(List.of(color));
        product1.setSizes(List.of(size));
        product1.setCategory(category);

        repository.save(product1);

        assertEquals(2, repository.findAll().size());
        assertEquals("Product 2", repository.findById(2L).get().getName());
    }

    @Test
    void getAllProducts() {

        Product product1 = new Product();
        product1.setId(2L);
        product1.setName("Product 2");
        product1.setPrice(200.30);
        product1.setImage("image.jpg");
        product1.setStock(10);
        product1.setColors(List.of(color));
        product1.setSizes(List.of(size));
        product1.setCategory(category);

        repository.save(product1);

        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Product 2", products.get(1).getName());
    }

    @Test
    void updateStock() {
        productService.updateStock(1L, 30);

        assertEquals(30, repository.findById(1L).get().getStock());
    }

    @Test
    void deleteProductById() {
        productService.deleteProductById(1L);

        assertEquals(0, repository.findAll().size());
    }
}