package com.fooddeliveryapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private String id;
    private List<CartItem> cartItemList;
    private double totalPrice;
}
