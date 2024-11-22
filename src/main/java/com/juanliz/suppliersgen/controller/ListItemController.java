package com.juanliz.suppliersgen.controller;

import com.juanliz.suppliersgen.model.ListItem;
import com.juanliz.suppliersgen.repository.ListItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/lists/{listId}/items")
public class ListItemController {

    private final ListItemRepository listItemRepository;

    public ListItemController(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @GetMapping
    public ResponseEntity<List<ListItem>> getListItems(@PathVariable int listId) {
        return ResponseEntity.ok(listItemRepository.findBySupplierListId(listId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListItem> getListItem(@PathVariable int id) {
        ListItem listItem = listItemRepository.findById(id).orElse(null);
        return listItem != null ? ResponseEntity.ok(listItem) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ListItem> saveListItem(@RequestBody ListItem listItem) {
        return ResponseEntity.ok(listItemRepository.save(listItem));
    }

    @PutMapping
    public ResponseEntity<ListItem> updateListItem(@RequestBody ListItem listItem) {
        ListItem updatedListItem = listItemRepository.save(listItem);
        return ResponseEntity.ok(updatedListItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListItem(@PathVariable int id) {
        listItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
