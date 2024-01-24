package com.example.shippingapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Availability {
    private Integer id;
    private Integer staffId;
    private LocalDateTime availableDateStart;
    private LocalDateTime availableDateEnd;
}
