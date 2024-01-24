package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private Integer id;
    private Integer itemId;
    private Integer userId;
    private Double orderAmount;
    private int quantity;
    
    // Getters and Setters
}