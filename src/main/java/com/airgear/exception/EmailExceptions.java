package com.airgear.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailExceptions {
    public static ResponseStatusException unableToSendEmail() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "An error occurred while sending the email. ");
    }

    public static ResponseStatusException unableToSaveEmail() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "An error occurred while saving the email.");
    }

    public static ResponseStatusException notFoundEmails() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Not found such emails");
    }

//    public static ResponseStatusException userNotFound(Long userId) {
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id '" + userId + "' was not found");
//    }
}
