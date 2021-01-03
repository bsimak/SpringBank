package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.UUID;
import java.time.ZonedDateTime;

public class Transaction {
    private String id;
    private String reference;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
    private ZonedDateTime timestamp;

    private Integer amount;

    public Transaction(){
    }
    public Transaction(Integer amount,String reference, ZonedDateTime timestamp){

        System.out.println("in Transaction Method" + reference);
        this.id = UUID.randomUUID().toString();
        this.timestamp = timestamp;
        this.reference = reference;
        this.amount = amount;
    }
    // Transaction Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
}
