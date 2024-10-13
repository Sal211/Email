package com.example.Email.Service;

import com.example.Email.Dtos.EmailDetails;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    String sendSimpleMail(EmailDetails details);
    String sendSimpleMailStyle(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
