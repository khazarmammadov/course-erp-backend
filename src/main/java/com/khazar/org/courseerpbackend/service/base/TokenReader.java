package com.khazar.org.courseerpbackend.service.base;

public interface TokenReader <T> {
     T read(String token);
}
