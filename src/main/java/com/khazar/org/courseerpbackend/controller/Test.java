package com.khazar.org.courseerpbackend.controller;

import com.khazar.org.courseerpbackend.exception.BaseException;
import com.khazar.org.courseerpbackend.models.base.BaseResponse;
import com.khazar.org.courseerpbackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private UserService userService;

    @GetMapping("/test/no-auth")
    public BaseResponse<String> test() {

        userService.getByEmail("asdfghjk");

        return BaseResponse.success("Course ERP");
    }
}
