package com.test.paymentgatway.services.implementions;

import com.test.paymentgatway.entities.Transaction;
import com.test.paymentgatway.repositories.TransactionRepository;
import com.test.paymentgatway.services.ITransactionService;
import com.test.paymentgatway.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;
    private final IUserService userService;

    public TransactionService(TransactionRepository transactionRepository, IUserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Override
    public Transaction create(Transaction transaction) {
        if(transaction.getUserId() != null && userService.get(transaction.getUserId()) == null){
            throw new RuntimeException("User not found");
        }
        if(transaction.getMerchantId() != null && userService.get(transaction.getMerchantId()) == null){
            throw new RuntimeException("MerchantId not found");
        }

        if(transaction.getIdempotencyKey() == null ){
            throw new RuntimeException("Idempotency key not found");
        }
        if(transaction.getAmount() == null || transaction.getAmount().doubleValue() <= 0){
            throw new RuntimeException("Amount should be greater than 0");
        }

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
