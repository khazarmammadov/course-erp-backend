package com.khazar.org.courseerpbackend.exception;


import com.khazar.org.courseerpbackend.exception.types.NotFoundExceptionType;
import com.khazar.org.courseerpbackend.models.enums.response.ResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

import static com.khazar.org.courseerpbackend.models.enums.response.ErrorResponseMessages.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException {

    ResponseMessages responseMessage;
    NotFoundExceptionType notFoundData;

    @Override
    public String getMessage() {
        return responseMessage.message();
    }

    public static  BaseException of(ResponseMessages responseMessages) {
        return BaseException.builder().responseMessage(responseMessages).build();
    }

    public static BaseException unexpected() {
        return of(UNEXPECTED);
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
