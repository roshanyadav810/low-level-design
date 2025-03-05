package com.fooddeliveryapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Menu {
    private String id;
    private Set<Dish> dishes;
}
