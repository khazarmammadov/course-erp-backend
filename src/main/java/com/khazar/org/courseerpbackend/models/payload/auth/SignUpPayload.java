package com.khazar.org.courseerpbackend.models.payload.auth;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpPayload {

    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    String courseName;
    String address;
}
