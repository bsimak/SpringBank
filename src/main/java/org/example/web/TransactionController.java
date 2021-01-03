package org.example.web;

import org.example.model.Transaction;
import org.example.service.TransactionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Validated
public class TransactionController {

        private final TransactionService transactionService;

        public TransactionController(TransactionService transactionService)
        {
            this.transactionService = transactionService;
        }
        // GET Method
        @RequestMapping(value="transactions", method = RequestMethod.GET)
        public List<Transaction> transactions() {
            return transactionService.findAll();
        }
        // Mit validation Bean in ApplicationLauncher Class
        @PostMapping("transactions")
        public Transaction createTransaction(@RequestParam @Min(10) @Max(100) Integer amount,
                                             @RequestParam @NotBlank String reference) {
            return transactionService.create(amount, reference);
        }
    }

