package com.example.eventmanagment.Controller;

import com.example.eventmanagment.Dto.EmailDTO;
import com.example.eventmanagment.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class EmailController {


        @Autowired
        private EmailService emailService;

        @PostMapping("/send")
        public String sendContactEmail(@RequestBody EmailDTO emailDto) {
            String emailBody = "Name: " + emailDto.getName() + "\n" +
                    "Message: " + emailDto.getMessage() + "\n";
            emailService.sendEmail("testemail@gmail.com", emailDto.getSubject(), emailBody, emailDto.getEmail());
            return "Email sent successfully!";
        }
    }

