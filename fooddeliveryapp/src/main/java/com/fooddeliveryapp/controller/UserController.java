package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.entity.User;
import com.fooddeliveryapp.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User>  get(String userId){
        return ResponseEntity.ok(userService.get(userId));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<User>  delete(String userId){
        return ResponseEntity.ok(userService.delete(userId));
    }
}
