package com.exercise.api.services;

import com.exercise.api.entities.ProductCategory;

import java.util.List;

public interface IProductCategoryService {

    void addProductCategory(ProductCategory productCategory);

    List<ProductCategory> getAllProductCategories();

    void updateProductCategory(Long id, ProductCategory productCategory);

    void deleteProductCategory(Long id);

}
