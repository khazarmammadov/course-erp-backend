package com.khazar.org.courseerpbackend.service.security;

import com.khazar.org.courseerpbackend.exception.BaseException;
import com.khazar.org.courseerpbackend.models.dto.RefreshTokenDto;
import com.khazar.org.courseerpbackend.models.mappers.UserEntityMapper;
import com.khazar.org.courseerpbackend.models.mybatis.role.Role;
import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import com.khazar.org.courseerpbackend.models.payload.auth.LoginPayload;
import com.khazar.org.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.khazar.org.courseerpbackend.models.payload.auth.SignUpPayload;
import com.khazar.org.courseerpbackend.models.response.LoginResponse;
import com.khazar.org.courseerpbackend.service.role.RoleService;
import com.khazar.org.courseerpbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.khazar.org.courseerpbackend.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServiceImpl implements AuthBusinessService {

    private final AuthenticationManager authenticationManager;
    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public LoginResponse login(LoginPayload payload) {

        authenticate(payload);

        return prepareLoginResponse(payload.getEmail(), payload.isRememberMe());

    }

    @Override
    public LoginResponse refresh(RefreshTokenPayload payload) {

        return prepareLoginResponse(refreshTokenManager.getEmail(payload.getRefreshToken()), payload.isRememberMe());


    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{} user logout succeed", userDetails.getUsername());
    }

    @Override
    public void signUp(SignUpPayload payload) {

        if (userService.checkByEmail(payload.getEmail())) {
            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
        }

        Role defaultRole = roleService.getDefaultRole();

        User user = UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(
                payload,
                passwordEncoder.encode(payload.getPassword()),
                defaultRole.getId());

        userService.insertUser(user);

    }

    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
        );
    }

    // private util methods

    private void authenticate(LoginPayload request) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Exception");
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean isRememberMe) {

        User user = userService.getByEmail(email);

        return LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(isRememberMe)
                                .build()
                ))
                .build();
    }
}
