package com.khazar.org.courseerpbackend;

import com.khazar.org.courseerpbackend.models.enums.user.UserStatus;
import com.khazar.org.courseerpbackend.models.mybatis.user.User;
import com.khazar.org.courseerpbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseErpBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CourseErpBackendApplication.class, args);
    }

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        User user = User.builder()
//                .name("Khazar")
//                .surname("Richer")
//                .status(UserStatus.ACTIVE)
//                .email("khazarmammadov@gmail.org")
//                .phoneNumber("+994554367479")
//                .password("123321X")
//                .roleId(1L)
//                .build();
//
//        repository.insert(user);
    }
}
