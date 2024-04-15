package com.airgear.service;

import com.airgear.dto.CustomEmailMessageDto;
import com.airgear.dto.UserDto;
import com.airgear.model.User;
import com.airgear.model.email.CustomEmailMessage;
import com.airgear.model.email.EmailMessage;

import java.util.Set;

public interface EmailService {
    String sendMail(EmailMessage emailMessage, Set<String> addresses);

    public String  sendWelcomeEmail(UserDto user);


    String sendCustomEmail(CustomEmailMessageDto request);

    public String  save(CustomEmailMessageDto message);
}
