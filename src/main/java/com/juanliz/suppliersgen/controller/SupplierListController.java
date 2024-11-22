package com.juanliz.suppliersgen.controller;

import com.juanliz.suppliersgen.model.SupplierList;
import com.juanliz.suppliersgen.repository.SupplierListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class SupplierListController {

    private final SupplierListRepository supplierListRepository;

    public SupplierListController(SupplierListRepository supplierListRepository) {
        this.supplierListRepository = supplierListRepository;
    }

    @GetMapping
    public ResponseEntity<List<SupplierList>> getSupplierLists() {
        return ResponseEntity.ok(supplierListRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierList> getSupplierListById(@PathVariable int id) {
        SupplierList supplierList = supplierListRepository.findById(id).orElse(null);
        return supplierList != null ? ResponseEntity.ok(supplierList) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SupplierList> saveSupplierList(@RequestBody SupplierList supplierList) {
        return ResponseEntity.ok(supplierListRepository.save(supplierList));
    }

    @PutMapping
    public ResponseEntity<SupplierList> updateSupplierList(@RequestBody SupplierList supplierList) {
        SupplierList updatedSupplierList = supplierListRepository.save(supplierList);
        return ResponseEntity.ok(updatedSupplierList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierList(@PathVariable int id) {
        supplierListRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
