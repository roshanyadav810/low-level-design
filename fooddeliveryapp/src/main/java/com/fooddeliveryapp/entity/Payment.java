package com.fooddeliveryapp.entity;

import com.fooddeliveryapp.entity.enums.PaymentMetnod;
import lombok.Data;

@Data
public class Payment {
    private String id;
    private double amount;
    private PaymentMetnod paymentMetnod;
    private PaymentStatus status;
}
