package com.model;

/**
 * Created by lasia on 2019/4/11.
 */
public class User {
    private String username;
    private String password;
    private Boolean isLocked;

    public User(String username, String password, Boolean isLocked) {
        this.username = username;
        this.password = password;
        this.isLocked = isLocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }
}
