package com.CaseStudy.inventoryservice.Repository;

import com.CaseStudy.inventoryservice.Model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Integer> {
    InventoryItem findByItemId(int itemId);
}
