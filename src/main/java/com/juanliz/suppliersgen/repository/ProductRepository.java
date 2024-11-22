package com.juanliz.suppliersgen.repository;

import com.juanliz.suppliersgen.model.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findBySku(int sku);
    List<Product> findAllByNameLike(@NotNull String name);

    List<Product> findAllByNameContainingIgnoreCase(@NotNull String name);
}
