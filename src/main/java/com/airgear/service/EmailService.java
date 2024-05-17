package com.airgear.service;

import com.airgear.dto.CustomEmailMessageDto;
import com.airgear.dto.UserGetResponse;
import com.airgear.entity.CustomEmailMessage;
import com.airgear.entity.EmailMessage;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmailService {
    String sendMail(EmailMessage emailMessage, Set<String> addresses);

    public String  sendWelcomeEmail(UserGetResponse user);


    String sendCustomEmail(CustomEmailMessageDto request);

    public String  save(CustomEmailMessageDto message);

    List<CustomEmailMessage> filterByEmail(String email);
}
