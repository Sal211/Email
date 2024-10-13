package com.example.Email.Service;

import com.example.Email.Dtos.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
                    .replace("{{date}}", details.getDate())
                    .replace("{{time}}", details.getTime())
                    .replace("{{deviceModel}}", "IPhone 13 Pro Max" )


            // CREATING A SIMPLE MAIL MESSAGE
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // SETTING UP NECESSARY DETAIL
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(emailContent);
            mailMessage.setSubject(details.getSubject());

            // SENDING THE MAIL
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return "";
    }
}
