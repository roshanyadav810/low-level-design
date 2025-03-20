package com.test.paymentgatway.services;

import com.test.paymentgatway.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface ITransactionService {
    Transaction create(Transaction transaction);
    Transaction getTransaction(UUID transactionId);
    List<Transaction> getTransactionsByUserId(UUID userId);
    List<Transaction> getTransactionsByMerchantId(UUID merchantId);
}
