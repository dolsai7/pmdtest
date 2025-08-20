package com.example.login.dto;

public class LoginResponse {
    private boolean success;
    private String message;
    private String id;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String message, String id) {
        this.success = success;
        this.message = message;
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(String id) {
        this.id = id;
    }

}
