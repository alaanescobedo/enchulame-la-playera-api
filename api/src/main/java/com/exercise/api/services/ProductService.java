package com.exercise.api.services;

import com.exercise.api.dtos.CreateProductDto;
import com.exercise.api.entities.Color;
import com.exercise.api.entities.Product;
import com.exercise.api.entities.ProductCategory;
import com.exercise.api.entities.Size;
import com.exercise.api.repositories.IColorRepository;
import com.exercise.api.repositories.IProductCategoryRepository;
import com.exercise.api.repositories.IProductRepository;
import com.exercise.api.repositories.ISizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ISizeRepository sizeRepository;
    @Autowired
    private IColorRepository colorRepository;
    @Autowired
    private IProductCategoryRepository categoryRepository;


    public void addProduct(CreateProductDto createProductDto) {
        try {
            System.out.println(">>>--- Creating product: " + createProductDto.toString());
            List<Size> sizes = sizeRepository.findAllById(createProductDto.getSizes());
            List<Color> colors = colorRepository.findAllById(createProductDto.getColors());
            ProductCategory category = categoryRepository.findById(createProductDto.getCategory()).get();

            System.out.println(">>>--- Category: " + category.toString());

            if (sizes.size() == 0) throw new IllegalStateException("Invalid size");
            if (colors.size() == 0) throw new IllegalStateException("Invalid color");

            Product product = new Product();
            product.setName(createProductDto.getName());
            product.setPrice(createProductDto.getPrice());
            product.setSizes(sizes);
            product.setColors(colors);
            product.setCategory(category);

            productRepository.save(product);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateStock(Long id, Integer stock) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent() == false) throw new IllegalStateException("Product not found");

        product.get().setStock(stock);
        return productRepository.save(product.get());
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

}
