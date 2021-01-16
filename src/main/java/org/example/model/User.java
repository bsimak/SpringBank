package org.example.model;

import java.util.UUID;

public class User {

    private String id;
    private String userId;
    private String name;
    private String pwd;

    public User(){
    }
    public User(String userId, String name, String pwd) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.name =name;
        this.pwd = pwd;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
