package com.CaseStudy.inventoryservice.Controller;

import com.CaseStudy.inventoryservice.Model.InventoryItem;
import com.CaseStudy.inventoryservice.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    
    @Autowired
    InventoryService service;

    @GetMapping("/inventory/getItem/{itemId}")
    public InventoryItem getInventoryItem(@PathVariable int itemId) {
        return service.getInventoryItem(itemId);
    }

    @PostMapping("/inventory/addItem")
    public InventoryItem addInventoryItem(@RequestBody InventoryItem item) {
        return service.addInventoryItem(item);
    }

    @PutMapping("/inventory/updateItem/{itemId}")
    public InventoryItem updateInventoryItem(@PathVariable int itemId, @RequestBody InventoryItem item) {
        return service.updateInventoryItem(itemId, item);
    }

    @DeleteMapping("/inventory/deleteItem/{itemId}")
    public void deleteInventoryItem(@PathVariable int itemId) {
        service.deleteInventoryItem(itemId);
    }
}
