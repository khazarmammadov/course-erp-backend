package com.khazar.org.courseerpbackend.service.base;

public interface TokenReader <T> {
     T reader(String token);
}
