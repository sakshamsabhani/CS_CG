package com.CaseStudy.inventoryservice.Service;

import com.CaseStudy.inventoryservice.Model.InventoryItem;

public interface InventoryService {
    InventoryItem getInventoryItem(int itemId);

    InventoryItem addInventoryItem(InventoryItem item);

    InventoryItem updateInventoryItem(int itemId, InventoryItem item);

    void deleteInventoryItem(int itemId);
}
