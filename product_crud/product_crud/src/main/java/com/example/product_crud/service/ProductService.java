package com.example.product_crud.service;

import com.example.product_crud.model.Product;
import com.example.product_crud.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Create product
    public Product save(Product product) {
        return repository.save(product);
    }

    // Get all products
    public List<Product> getAll() {
        return repository.findAll();
    }

    // Update product
    public Product update(Long id, Product product) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        return repository.save(existing);
    }

    // Delete product
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
