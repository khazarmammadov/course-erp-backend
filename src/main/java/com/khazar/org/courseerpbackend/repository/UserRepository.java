package com.khazar.org.courseerpbackend.repository;

import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    void insert(User user);
}
