package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(String toEmail,
                                        String subject,
                                        String body,
                                        String attachmentPath) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("nanduchavan2232@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body, true); // 'true' enables HTML content

            // Add the attachment
            File attachment = new File(attachmentPath);
            helper.addAttachment(attachment.getName(), attachment);

            mailSender.send(message);

            System.out.println("Message with attachment sent...........");
        } catch (Exception e) {
            System.out.println("Error sending email with attachment: " + e.getMessage());
        }
    }
}
