package com.khazar.org.courseerpbackend.controller;

import com.khazar.org.courseerpbackend.models.base.BaseResponse;
import com.khazar.org.courseerpbackend.models.dto.RefreshTokenDto;
import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import com.khazar.org.courseerpbackend.models.payoad.auth.LoginPayload;
import com.khazar.org.courseerpbackend.models.response.LoginResponse;
import com.khazar.org.courseerpbackend.service.security.AccessTokenManager;
import com.khazar.org.courseerpbackend.service.security.RefreshTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {

        User user = User.builder().email("kh@gmail.com").build();
        user.setId(1L);

        return BaseResponse.success(LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(payload.isRememberMe())
                                .build()
                ))
                .build()
        );
    }
}
