package com.CaseStudy.inventoryservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int itemId;

    private String name;
    private int quantity;
    private double price;
}
