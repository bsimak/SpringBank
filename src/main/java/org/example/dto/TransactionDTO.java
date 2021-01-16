package org.example.dto;

import java.time.ZonedDateTime;

public class TransactionDTO {

    private String reference;
    private Integer amount;
    private ZonedDateTime timestamp;

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
}
