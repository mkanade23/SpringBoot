package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodItem {
    private Integer itemId;
    private String itemName;
    private Double cost;
}
