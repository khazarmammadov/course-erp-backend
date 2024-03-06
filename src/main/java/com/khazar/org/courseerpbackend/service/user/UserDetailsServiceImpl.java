package com.khazar.org.courseerpbackend.service.user;

import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import com.khazar.org.courseerpbackend.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByEmail(username);

        return new LoggedInUserDetails(
                user.getEmail(), user.getPassword(), new ArrayList<>()
        );
    }
}
