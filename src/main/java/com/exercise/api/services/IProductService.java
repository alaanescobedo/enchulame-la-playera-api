package com.exercise.api.services;

import com.exercise.api.dtos.CreateProductDto;
import com.exercise.api.entities.Product;

import java.util.List;

public interface IProductService {

    void addProduct(CreateProductDto createProductDto);

    List<Product> getAllProducts();

    Product updateStock(Long id, Integer stock);

    void deleteProductById(Long id);
}
