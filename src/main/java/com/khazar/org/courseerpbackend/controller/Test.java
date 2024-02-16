package com.khazar.org.courseerpbackend.controller;

import com.khazar.org.courseerpbackend.models.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test")
    public BaseResponse<String> test() {
        return BaseResponse.success("Course ERP");
    }
}
