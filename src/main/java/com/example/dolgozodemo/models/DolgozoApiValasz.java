package com.example.dolgozodemo.models;

import com.example.dolgozodemo.core.ApiResponse;

import java.util.List;

public class DolgozoApiValasz extends ApiResponse<Dolgozo> {
    public DolgozoApiValasz(boolean error, String message, List<Dolgozo> adatok) {
        super(error, message, adatok);
    }
}
