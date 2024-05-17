package com.airgear.controller;

import com.airgear.dto.CustomEmailMessageDto;
import com.airgear.dto.UserGetResponse;
import com.airgear.entity.CustomEmailMessage;
import com.airgear.entity.EmailsRequestStructure;
import com.airgear.service.impl.EmailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/mail")
public class EmailController {

    private EmailServiceImpl emailService;

    @Autowired
    public EmailController(EmailServiceImpl emailService){
        this.emailService=emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailsRequestStructure request) {
        return emailService.sendMail(request.getEmailMessage(), request.getAddresses());
    }

    @PostMapping("/custom-message")
    public String sendCustomEmail(@RequestBody CustomEmailMessageDto request) {
        return emailService.sendCustomEmail(request);
    }

    @PostMapping("/welcome-message")
    public String sendWelcomeEmail(@RequestBody UserGetResponse user) {
        return emailService.sendWelcomeEmail(user);
    }

    @PostMapping("/save-message")
    public ResponseEntity<String> saveMessage(@RequestBody CustomEmailMessageDto message) {
        return ResponseEntity.ok(emailService.save(message));
    }

    @GetMapping("/filter-by-email/")
    public ResponseEntity<List<CustomEmailMessage>> filterByEmail(@RequestParam String email) {
        return ResponseEntity.ok(emailService.filterByEmail(email));
    }
}
