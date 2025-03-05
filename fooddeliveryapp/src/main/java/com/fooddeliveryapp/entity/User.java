package com.fooddeliveryapp.entity;

import com.fooddeliveryapp.entity.enums.UserStatus;
import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String passwordHash;
    private UserStatus status;
}
