package com.khazar.org.courseerpbackend.service.base;

public interface TokenGenerator <T> {

    String generate(T obj);
}
