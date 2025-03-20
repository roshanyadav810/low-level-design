package com.test.paymentgatway.controllers;

import com.test.paymentgatway.entities.Transaction;
import com.test.paymentgatway.services.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction){
        return ResponseEntity.ok().body(transactionService.create(transaction));
    }

    @RequestMapping(path = "/{transactionId}", method = RequestMethod.GET)
    public ResponseEntity<Transaction> getTransaction(@PathVariable String transactionId){
        return ResponseEntity.ok().body(transactionService.getTransaction(UUID.fromString(transactionId)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@RequestParam(required = false) String userId , @RequestParam(required = false) String merchantId){
        if(merchantId != null){
            return ResponseEntity.ok().body(transactionService.getTransactionsByMerchantId(UUID.fromString(merchantId)));
        } else if (userId != null) {
            return ResponseEntity.ok().body(transactionService.getTransactionsByUserId(UUID.fromString(userId)));
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }


}
