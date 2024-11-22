package com.juanliz.suppliersgen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(name = "sku", columnList = "sku", unique = true),
        @Index(name = "name", columnList = "name")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @NotNull
    private int sku;
    @NotNull
    private String name;
    @NotNull
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;
    @NotNull
    @Column(name = "measure_unit_id", nullable = false)
    private int measureUnitId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "measure_unit_id", insertable = false, updatable = false)
    private MeasureUnit measureUnit;

}
