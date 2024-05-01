package com.airgear.repository;

import com.airgear.model.email.CustomEmailMessage;
import org.springframework.data.repository.CrudRepository;

public interface EmailMessageRepository extends CrudRepository<CustomEmailMessage, Long> {
}
