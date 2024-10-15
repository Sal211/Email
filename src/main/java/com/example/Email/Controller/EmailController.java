package com.example.Email.Controller;

import com.example.Email.Dtos.EmailDetails;
import com.example.Email.Dtos.NotificationResponse;
import com.example.Email.Service.EmailService;
import com.example.Email.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details){
        String status = emailService.sendSimpleMailStyle(details);
        return status;
    }

    @GetMapping("/notification")
    public NotificationResponse getNotification(){
        return notificationService.getNotification();
    }
}
