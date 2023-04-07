package com.payment.paymentwebservice.web.rest;

import com.payment.paymentwebservice.domain.Transaction;
import com.payment.paymentwebservice.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionResource {
    private final TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public ResponseEntity create(@RequestBody Transaction transaction) {
        Transaction result = transactionService.save(transaction);
        return ResponseEntity.ok(result);
    }

    @GetMapping("transactions")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }
}
