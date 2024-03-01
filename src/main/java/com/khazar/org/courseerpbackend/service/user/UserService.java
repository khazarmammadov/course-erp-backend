package com.khazar.org.courseerpbackend.service.user;

import com.khazar.org.courseerpbackend.models.mybatis.user.User;

public interface UserService {

    User getByEmail(String email);
}
