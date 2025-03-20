package com.test.paymentgatway.services;

import com.test.paymentgatway.entities.Refund;

import java.util.UUID;

public interface IRefundService {
    Refund refund(UUID transactionId);
}
