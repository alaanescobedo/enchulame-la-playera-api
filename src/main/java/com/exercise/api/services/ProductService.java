package com.exercise.api.services;

import com.exercise.api.entities.dtos.CreateProductDto;
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
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ISizeRepository sizeRepository;
    @Autowired
    private IColorRepository colorRepository;
    @Autowired
    private IProductCategoryRepository categoryRepository;

    public Product addProduct(CreateProductDto createProductDto) {
        try {
            Size size = sizeRepository.findById(createProductDto.getSizes()).orElse(null);
            Color color = colorRepository.findById(createProductDto.getColors()).orElse(null);
            ProductCategory category = categoryRepository.findById(createProductDto.getCategory()).get();

            if (size == null) throw new IllegalStateException("Invalid size");
            if (color == null) throw new IllegalStateException("Invalid color");
            if (category == null) throw new IllegalStateException("Invalid category");

            Product product = new Product();
            product.setName(createProductDto.getName());
            product.setPrice(createProductDto.getPrice());
            product.setImage(createProductDto.getImg());
            product.setStock(createProductDto.getStock());
            product.setSizes(List.of(size));
            product.setColors(List.of(color));
            product.setCategory(category);

            return productRepository.save(product);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public Product getProductById(Long id) {
        try {
            Product product = productRepository.findById(id).orElse(null);
            if (product == null) throw new IllegalStateException("Product not found");
            return product;
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
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
