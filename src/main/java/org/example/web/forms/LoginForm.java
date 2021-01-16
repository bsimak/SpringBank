package org.example.web.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotBlank
    private String userId = "";
    private final String username = "";
    private String pwd = "";

    public String getUserId() {
        return userId;
    }
    public void setUserId (String userId) {
        this.userId = userId;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd (String pwd) {
        this.pwd = pwd;
    }
}
