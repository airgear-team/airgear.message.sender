package com.airgear.repository;

import com.airgear.entity.CustomEmailMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface EmailMessageRepository extends CrudRepository<CustomEmailMessage, Long> {
    List<CustomEmailMessage> findAllByRecipient(String recipient);
}
