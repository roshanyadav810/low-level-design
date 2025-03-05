package com.fooddeliveryapp.service.implemention;

import com.fooddeliveryapp.entity.Dish;
import com.fooddeliveryapp.entity.Menu;
import com.fooddeliveryapp.entity.Restaurant;
import com.fooddeliveryapp.service.IRestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RestaurantServiceImp implements IRestaurantService {
    private final Set<Restaurant> restaurantDb;

    public RestaurantServiceImp() {
        this.restaurantDb = new HashSet<>();
    }

    @Override
    public Restaurant add(Restaurant restaurant) {
        restaurant.setId(UUID.randomUUID().toString());
        restaurantDb.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant addDish(String restaurantId, Dish dish) {
        for(Restaurant restaurant : restaurantDb){
            if(restaurant.getId().equals(restaurantId)){
                if(restaurant.getMenu() == null){
                    Menu menu = new Menu(UUID.randomUUID().toString(),new HashSet<Dish>());
                    restaurant.setMenu(menu);
                }
                if(restaurant.getMenu().getDishes() == null){
                    restaurant.getMenu().setDishes(new HashSet<Dish>());
                }
                Set<Dish> dishSet = restaurant.getMenu().getDishes();
                dish.setId(UUID.randomUUID().toString());
                dishSet.add(dish);
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public Restaurant removeDish(String restaurantId, String dishId) {
        for(Restaurant restaurant : restaurantDb){
            if(restaurant.getId().equals(restaurantId)){

                Set<Dish> dishSet = restaurant.getMenu().getDishes();
                dishSet.removeIf(dish -> dish.getId().equals(dishId));
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public List<Restaurant> searchDish(String dishName) {
        return restaurantDb.stream()
                .filter(restaurant -> restaurant.getMenu() != null && restaurant.getMenu().getDishes() != null)
                .filter(restaurant -> restaurant.getMenu().getDishes().stream()
                        .anyMatch(dish -> dish.getName().equalsIgnoreCase(dishName)))
                .collect(Collectors.toList());
    }
}
