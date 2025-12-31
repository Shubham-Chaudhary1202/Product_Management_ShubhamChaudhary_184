package com.example.product_crud.controller;

import com.example.product_crud.model.Product;
import com.example.product_crud.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }

    // READ
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {
        return service.update(id, product);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return "Product deleted successfully";
    }
}
