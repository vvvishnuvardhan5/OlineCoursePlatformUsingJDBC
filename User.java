package com.onlinecourseplatform.model;

public class User {

    private int user_Id;
    private String username;
    private String email;
    private String password;
    private String role;

    public User() {}

    public User(int userId, String username, String email, String password, String role) {
        this.user_Id = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return user_Id;
    }

    public void setUserId(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	
	
	
	
}
