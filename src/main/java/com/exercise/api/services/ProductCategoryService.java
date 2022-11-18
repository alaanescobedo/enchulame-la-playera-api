package com.exercise.api.services;

import com.exercise.api.entities.ProductCategory;
import com.exercise.api.repositories.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) {
       return productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public void updateProductCategory(Long id, ProductCategory productCategory) {
        ProductCategory productCategoryToUpdate = productCategoryRepository.findById(id).get();
        productCategoryToUpdate.setName(productCategory.getName());
        productCategoryRepository.save(productCategoryToUpdate);
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
