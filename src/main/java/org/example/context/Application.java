package org.example.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.TransactionService;

public class Application {
    public static final TransactionService transactionService = new TransactionService();
    public static final ObjectMapper objectMapper = new ObjectMapper();

}

