package com.test.paymentgatway.services.implementions;

import com.test.paymentgatway.entities.Transaction;
import com.test.paymentgatway.repositories.TransactionRepository;
import com.test.paymentgatway.services.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction create(Transaction transaction) {
        transaction = transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public Transaction getTransaction(UUID transactionId) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
        if(transactionOptional.isEmpty()){
            throw new RuntimeException("Transaction not found");
        }
        return transactionOptional.get();
    }

    @Override
    public List<Transaction> getTransactionsByUserId(UUID userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public List<Transaction> getTransactionsByMerchantId(UUID merchantId) {
        return transactionRepository.findByMerchantId(merchantId);
    }
}
