package com.khazar.org.courseerpbackend.models.enums.response;

import org.springframework.http.HttpStatus;

public interface ResponseMessages {

    String key();
    String message();
    HttpStatus status();
}
