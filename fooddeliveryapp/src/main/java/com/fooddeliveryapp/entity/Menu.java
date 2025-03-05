package com.fooddeliveryapp.entity;

import lombok.Data;

@Data
public class Menu {
    private String id;
    private List<Dish> dishes;
}
