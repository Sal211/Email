package com.example.Email.Dtos;

import lombok.Data;

import java.util.Map;

@Data
public class NotificationResponse {
    String title;
    String subtitle;
    String greeting;
    Map<String,Object> body;
    String warning;

    String error = "";

    public void isError(String e){
        error = e;
    }

}

