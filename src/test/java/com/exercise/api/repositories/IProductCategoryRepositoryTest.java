package com.exercise.api.repositories;

import com.exercise.api.entities.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IProductCategoryRepositoryTest {

    @Autowired
    private IProductCategoryRepository categoryRepository;

    @Test
    public void addCategory() {
        ProductCategory category = new ProductCategory();
        category.setName("Anime");
        categoryRepository.save(category);
    }
}