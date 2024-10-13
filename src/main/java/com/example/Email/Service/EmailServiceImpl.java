package com.example.Email.Service;

import com.example.Email.Dtos.EmailDetails;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${email.template.loginNotification}")
    private String loginNotificationTemplate;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        try{
            String emailContent = loginNotificationTemplate
                    .replace("{{name}}", "Lionel Messi")
                    .replace("{{date}}", formatTime())
                    .replace("{{deviceModel}}", "IPhone 13 Pro Max" );


            // CREATING A SIMPLE MAIL MESSAGE
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // SETTING UP NECESSARY DETAIL
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(emailContent);
            mailMessage.setSubject("Unusual Login Detected");

            // SENDING THE MAIL
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String sendSimpleMailStyle(EmailDetails details) {
        try{
            String emailContent = loginNotificationTemplate
                    .replace("{{name}}", "Lionel Messi")
                    .replace("{{date}}", formatTime())
                    .replace("{{deviceModel}}", "IPhone 13 Pro Max" );


            // Create a MimeMessage for HTML content
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender); // Replace with your sender email
            helper.setTo(details.getRecipient());
            helper.setSubject("Unusual Login Detected");
            helper.setText(emailContent, true); // true indicates it's HTML content

            // SENDING THE MAIL
            javaMailSender.send(message);
            return "Mail Sent Successfully...";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return "";
    }

    private String formatTime(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy 'at' HH:mm:ss");
        String formattedDateTime = date.format(formatter);
        return  formattedDateTime;
    }

}
