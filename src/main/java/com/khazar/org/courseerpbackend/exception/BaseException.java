package com.khazar.org.courseerpbackend.exception;


import com.khazar.org.courseerpbackend.exception.types.NotFoundExceptionType;
import com.khazar.org.courseerpbackend.models.enums.response.ResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

import static com.khazar.org.courseerpbackend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.khazar.org.courseerpbackend.models.enums.response.ErrorResponseMessages.UNEXPECTED;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException{

    ResponseMessages responseMessage;
    NotFoundExceptionType notFoundData;

    @Override
    public String getMessage() {
        return responseMessage.message();
    }

    public static BaseException unexpected() {
        return BaseException.builder()
                .responseMessage(UNEXPECTED)
                .build();
    }

    public static BaseException notFound(String target, String filed, String value) {
        return BaseException.builder()
                .responseMessage(NOT_FOUND)
                .notFoundData(
                        NotFoundExceptionType.of(target, Map.of(filed, value))
                )
                .build();
    }


}
