package com.khazar.org.courseerpbackend.controller;

import com.khazar.org.courseerpbackend.models.base.BaseResponse;
import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import com.khazar.org.courseerpbackend.models.response.LoginResponse;
import com.khazar.org.courseerpbackend.service.security.AccessTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccessTokenManager accessTokenManager;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login() {

        User user = User.builder().email("kh@gmail.com").build();
                user.setId(1L);

        return BaseResponse.success(LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(accessTokenManager.generate(user))
                .build()
        );
    }
}
