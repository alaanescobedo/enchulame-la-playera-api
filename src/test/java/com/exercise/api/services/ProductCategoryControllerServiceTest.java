package com.exercise.api.services;

import com.exercise.api.entities.ProductCategory;
import com.exercise.api.repositories.IProductCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductCategoryControllerServiceTest {

    @Autowired
    private IProductCategoryRepository repository;

    @Autowired
    private ProductCategoryService service;

    private ProductCategory productCategory;

    @BeforeEach
    void setUp() {
        productCategory = new ProductCategory();
        productCategory.setName("Category 1");
        productCategory.setId(1L);

        service.addProductCategory(productCategory);
    }

    @DisplayName("Debería agregar una categoría de producto")
    @Test
    void addProductCategory() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Category 2");
        productCategory.setId(2L);

        service.addProductCategory(productCategory);

        ProductCategory productCategoryAdded = repository.findById(productCategory.getId()).orElse(null);

        assertNotNull(productCategoryAdded);
        assertEquals(productCategoryAdded.getName(), productCategory.getName());
    }

    @DisplayName("Debería obtener todas las categorías de producto")
    @Test
    void getAllProductCategories() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Category 2");
        productCategory.setId(2L);

        repository.save(productCategory);

        List<ProductCategory> productCategories = service.getAllProductCategories();

        assertEquals(2, productCategories.size());
    }

    @DisplayName("Debería actualizar una categoría de producto")
    @Test
    void updateProductCategory() {

        productCategory.setName("Category 1 updated");
        service.updateProductCategory(productCategory.getId(), productCategory);

        ProductCategory productCategoryUpdated = repository.findById(productCategory.getId()).orElse(null);

        assertNotNull(productCategoryUpdated);
        assertEquals(productCategoryUpdated.getName(), productCategory.getName());
    }

    @DisplayName("Debería eliminar una categoría de producto")
    @Test
    void deleteProductCategory() {

        service.deleteProductCategory(productCategory.getId());

        ProductCategory productCategoryDeleted = repository.findById(productCategory.getId()).orElse(null);

        assertNull(productCategoryDeleted);
    }
}