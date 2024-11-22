package com.juanliz.suppliersgen.controller;

import com.juanliz.suppliersgen.model.Product;
import com.juanliz.suppliersgen.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Product>> getProducts( @RequestParam String name) {
        return ResponseEntity.ok(productRepository.findAllByNameContainingIgnoreCase(name));
    }

    @GetMapping(params = "sku")
    public ResponseEntity<Product> getProductBySku(@RequestParam int sku) {
        Product product = productRepository.findBySku(sku);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

}
