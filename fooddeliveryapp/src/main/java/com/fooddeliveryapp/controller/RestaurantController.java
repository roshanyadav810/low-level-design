package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.entity.Dish;
import com.fooddeliveryapp.entity.Restaurant;
import com.fooddeliveryapp.service.IRestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@Slf4j
@RequiredArgsConstructor
public class RestaurantController {
    private final IRestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Restaurant> add(Restaurant restaurant){
        return ResponseEntity.ok(restaurantService.add(restaurant));
    }

    @RequestMapping(method = RequestMethod.POST,path = "/{restaurantId}")
    public ResponseEntity<Restaurant>  addDish(@PathVariable String restaurantId, @RequestBody Dish dish){
        return ResponseEntity.ok(restaurantService.addDish(restaurantId,dish));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{restaurantId}/dishes/{dishId}")
    public ResponseEntity<Restaurant>  removeDish(@PathVariable String restaurantId,@PathVariable String dishId){
        return ResponseEntity.ok(restaurantService.removeDish(restaurantId,dishId));
    }

    @RequestMapping(method = RequestMethod.GET,path = "/search")
    public ResponseEntity<List<Restaurant>>  searchDish(@RequestParam String dishName){
        return ResponseEntity.ok(restaurantService.searchDish(dishName));
    }
}
