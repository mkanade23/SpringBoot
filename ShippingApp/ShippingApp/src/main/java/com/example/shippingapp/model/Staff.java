package com.example.shippingapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Staff {
    private Integer id;
    private String name;
    private String phone;
}
