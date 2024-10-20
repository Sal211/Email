package com.example.email2.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "login-detected-message")
@Data
public class LoginMessage {
    private String title;
    private String subtitle;
    private String message;
    private String warning;
}
