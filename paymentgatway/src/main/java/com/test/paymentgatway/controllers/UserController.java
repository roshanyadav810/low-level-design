package com.test.paymentgatway.controllers;

import com.test.paymentgatway.entities.User;
import com.test.paymentgatway.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // Add your code here

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok().body(userService.add(user));
    }
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> get(String userId){
        return ResponseEntity.ok().body(userService.get(UUID.fromString(userId)));
    }
}
