package com.khazar.org.courseerpbackend.service.security;

import com.khazar.org.courseerpbackend.models.payload.auth.LoginPayload;
import com.khazar.org.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.khazar.org.courseerpbackend.models.payload.auth.SignUpPayload;
import com.khazar.org.courseerpbackend.models.response.LoginResponse;


public interface AuthBusinessService {

    LoginResponse login(LoginPayload loginPayload);
    LoginResponse refresh(RefreshTokenPayload refreshTokenPayload);
    void logout();
    void signUp(SignUpPayload sign);
    void setAuthentication(String email);

}
