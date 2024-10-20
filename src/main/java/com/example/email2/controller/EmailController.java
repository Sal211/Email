package com.example.email2.controller;

import com.example.email2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService service;

    @GetMapping("/mail/{id}")
    public String sendEmail(@PathVariable("id")String id){
        return service.sendToMail(id);
    }
}
