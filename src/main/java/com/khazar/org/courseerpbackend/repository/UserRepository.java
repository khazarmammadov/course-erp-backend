package com.khazar.org.courseerpbackend.repository;

import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserRepository {
    void insert(User user);
    Optional<User> findByEmail(@Param("email") String email);

}
