package com.khazar.org.courseerpbackend.service.user;

import com.khazar.org.courseerpbackend.exception.BaseException;
import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import com.khazar.org.courseerpbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        userRepository.insert(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow( () -> BaseException.notFound(User.class.getSimpleName(), "email", email)
        );
    }

    @Override
    public boolean checkByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
