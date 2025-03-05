package com.fooddeliveryapp.entity;

import lombok.Data;

@Data
public class Dish {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
