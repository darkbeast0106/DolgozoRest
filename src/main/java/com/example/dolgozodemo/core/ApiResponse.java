package com.example.dolgozodemo.core;

import java.util.List;

public abstract class ApiResponse<T> {
    private boolean error;
    private String message;
    private List<T> adatok;

    public ApiResponse(boolean error, String message, List<T> adatok) {
        this.error = error;
        this.message = message;
        this.adatok = adatok;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getAdatok() {
        return adatok;
    }

    public void setAdatok(List<T> adatok) {
        this.adatok = adatok;
    }
}