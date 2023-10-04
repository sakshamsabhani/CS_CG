package com.CaseStudy.inventoryservice.Service;

import com.CaseStudy.inventoryservice.Model.InventoryItem;
import com.CaseStudy.inventoryservice.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository repository;

    @Override
    public InventoryItem getInventoryItem(int itemId) {
        return repository.findByItemId(itemId);
    }

    @Override
    public InventoryItem addInventoryItem(InventoryItem item) {
        return repository.save(item);
    }

    @Override
    public InventoryItem updateInventoryItem(int itemId, InventoryItem item) {
        repository.deleteById(itemId);
        return repository.save(item);
    }

    @Override
    public void deleteInventoryItem(int itemId) {
        repository.deleteById(itemId);
    }
}
