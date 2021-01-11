package org.example.web.forms;

import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;

public class AccountForm {
    @NotBlank
    private String username ="Barbara";
    private String transaction = "";

    public String getUsername() {
        return username;
    }
    public void setUsername (String username) {
        this.username = username;
    }
    public String getTransaction() {
        return transaction;
    }
    public void setTransaction (String transaction) {
        this.transaction = transaction;
    }
}
