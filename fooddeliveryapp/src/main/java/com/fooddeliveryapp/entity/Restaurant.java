package com.fooddeliveryapp.entity;

import com.fooddeliveryapp.entity.enums.RestaurantStatus;
import lombok.Data;

@Data
public class Restaurant {
    private String id;
    private String name;
    private Menu menu;
    private String openingTime;
    private String closingTime;
    private RestaurantStatus status;
}
