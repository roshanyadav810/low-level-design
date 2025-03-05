package com.fooddeliveryapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    private String id;
    private Dish dish;
    private int quantity;
}
