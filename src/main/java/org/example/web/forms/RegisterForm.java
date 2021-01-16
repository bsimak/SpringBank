package org.example.web.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterForm {

    @NotBlank
    @Size(min = 5, max = 20)
    private String userId;
    @NotBlank
    private String username = "";
    @NotBlank
    private String pwd = "";
    private final boolean register = "FALSE";
    private final boolean cancel = "FALSE";

    public RegisterForm () {
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId (String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername (String username) { this.username = username; }

    public String getPwd() { return pwd; }
    public void setPwd (String pwd) { this.pwd = pwd; }
}
