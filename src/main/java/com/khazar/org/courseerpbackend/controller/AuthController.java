package com.khazar.org.courseerpbackend.controller;

import com.khazar.org.courseerpbackend.models.base.BaseResponse;
import com.khazar.org.courseerpbackend.models.payload.auth.LoginPayload;
import com.khazar.org.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.khazar.org.courseerpbackend.models.response.LoginResponse;
import com.khazar.org.courseerpbackend.service.security.AuthBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {

        return BaseResponse.success(authBusinessService.login(payload));
    }

    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refresh(@RequestBody RefreshTokenPayload payload) {
        return BaseResponse.success(authBusinessService.refresh(payload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout() {
        authBusinessService.logout();
        return BaseResponse.success();
    }
}
