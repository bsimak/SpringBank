package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.UUID;
import java.time.ZonedDateTime;

public class Transaction {
    private String id;
    private String userId;
    private String reference;
    private Integer amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
    private ZonedDateTime timestamp;

    public Transaction(){
    }
    public Transaction( ZonedDateTime timestamp, String userId, Integer amount,String reference){

        System.out.println("in Transaction Method" + reference);
        this.id = UUID.randomUUID().toString();
        this.timestamp = timestamp;
        this.userId = userId;
        this.amount = amount;
        this.reference = reference;
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

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
}
