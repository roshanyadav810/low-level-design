package com.fooddeliveryapp.service;

import com.fooddeliveryapp.entity.Dish;
import com.fooddeliveryapp.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

    Restaurant add(Restaurant restaurant);

    Restaurant addDish(String restaurantId,Dish dish);

    Restaurant removeDish(String restaurantId,String dishId);

    List<Restaurant> searchDish(String dishName);

}
