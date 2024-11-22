package com.juanliz.suppliersgen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @NotNull
    @Column(name = "supplier_list_id", nullable = false)
    private int supplierListId;
    @NotNull
    @Column(name = "product_id", nullable = false)
    private int productId;
    @NotNull
    private int quantity;
    private String comment;
    @NotNull
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "supplier_list_id", insertable = false, updatable = false)
    private SupplierList supplierList;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
}
