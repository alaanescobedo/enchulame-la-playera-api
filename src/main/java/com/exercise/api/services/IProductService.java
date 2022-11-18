package com.exercise.api.services;

import com.exercise.api.entities.dtos.CreateProductDto;
import com.exercise.api.entities.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(CreateProductDto createProductDto);

    List<Product> addMultipleProducts(List<CreateProductDto> createProductDtos);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateStock(Long id, Integer stock);

    void deleteProductById(Long id);
}
