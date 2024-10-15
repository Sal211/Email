package com.example.Email.Service;

import com.example.Email.Dtos.LoginMessage;
import com.example.Email.Dtos.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class NotificationService {

    @Autowired
    private LoginMessage loginMessage;

    public NotificationResponse getNotification(){
        NotificationResponse response = new NotificationResponse();
        try{
            String greeting = "Dear Lionel Messi,";
            // SET VALUE TO BODY
            Map<String, Object> body = new HashMap<>();
            body.put("message",loginMessage.getMessage());
            body.put("time",formatTime());
            body.put("device","iPhone 13 Pro Max");

            // RESPONSE
            response.setBody(body);
            response.setTitle(loginMessage.getTitle());
            response.setSubtitle(loginMessage.getSubtitle());
            response.setWarning(loginMessage.getWarning());
            response.setGreeting(greeting);
            return  response;
        }catch (Exception e){
            response.isError(e.getMessage());
            return response;
        }
    }

    private String formatTime(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy 'at' HH:mm:ss");
        String formattedDateTime = date.format(formatter);
        return  formattedDateTime;
    }
}
