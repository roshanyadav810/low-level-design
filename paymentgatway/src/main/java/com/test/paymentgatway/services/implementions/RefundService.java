package com.test.paymentgatway.services.implementions;

import com.test.paymentgatway.entities.Refund;
import com.test.paymentgatway.entities.Transaction;
import com.test.paymentgatway.repositories.RefundRepository;
import com.test.paymentgatway.services.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class RefundService implements IRefundService {
    private final RefundRepository refundRepository;
    private final TransactionService transactionService;

    public RefundService(RefundRepository refundRepository, TransactionService transactionService) {
        this.refundRepository = refundRepository;
        this.transactionService = transactionService;
    }

    @Override
    public Refund refund(UUID transactionId) {
        log.info("Refunding transaction {}", transactionId);
        Transaction transaction = transactionService.getTransaction(transactionId);
        Refund refund = Refund.builder()
                .transactionId(transactionId)
                .amount(transaction.getAmount())
                .currency(transaction.getCurrency())
                .build();
        return refund = refundRepository.save(refund);
    }
}
