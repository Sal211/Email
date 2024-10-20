package com.example.email2.service;

import com.example.email2.dto.BaseRespone;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailService  {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${email.template.loginNotification}")
    private String loginNotificationTemplate;

    public String sendToMail(String recipient){
        try{
            String emailContent = loginNotificationTemplate
                    .replace("{{name}}", "Lionel Messi")
                    .replace("{{date}}", formatTime())
                    .replace("{{deviceModel}}", "IPhone 13 Pro Max" );

            sendMailAsync(emailContent,recipient);
            return "Mail Sent Successfully...";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Async
    private CompletableFuture<BaseRespone<Void>> sendMailAsync(String emailContent, String recipient) throws Exception {
        BaseRespone<Void> respone = new BaseRespone<>();
        try{
            // Create a MimeMessage for HTML content
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(sender);
            helper.setTo(recipient);
            helper.setSubject("Unusual Login Detected");
            helper.setText(emailContent, true); // true indicates it's HTML content

            // SENDING THE MAIL
            javaMailSender.send(message);

            respone.setSuccess(true);
            return CompletableFuture.completedFuture(respone);
        }catch (MessagingException e){
            throw new Exception(e.getMessage());
        }
    }

    private String formatTime(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy 'at' HH:mm:ss");
        String formattedDateTime = date.format(formatter);
        return  formattedDateTime;
    }
}
