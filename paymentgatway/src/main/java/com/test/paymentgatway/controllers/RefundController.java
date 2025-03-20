package com.test.paymentgatway.controllers;

import com.test.paymentgatway.entities.Refund;
import com.test.paymentgatway.services.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/refunds")
public class RefundController {
    private final IRefundService refundService;

    public RefundController(IRefundService refundService) {
        this.refundService = refundService;
    }
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Refund> refund(@RequestParam String transactionId){
        return ResponseEntity.ok().body(refundService.refund(UUID.fromString(transactionId)));
    }
}
