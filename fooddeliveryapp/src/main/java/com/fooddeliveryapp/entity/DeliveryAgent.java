package com.fooddeliveryapp.entity;

import com.fooddeliveryapp.entity.enums.UserStatus;
import lombok.Data;

@Data
public class DeliveryAgent {
    private String id;
    private String name;
    private String email;
    private String passwordHash;
    private DeliveryAgentStatus status;
}
