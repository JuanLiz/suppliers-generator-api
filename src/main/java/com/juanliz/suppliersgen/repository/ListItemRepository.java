package com.juanliz.suppliersgen.repository;

import com.juanliz.suppliersgen.model.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListItemRepository extends JpaRepository<ListItem, Integer> {
    List<ListItem> findBySupplierListId(int listId);

}
