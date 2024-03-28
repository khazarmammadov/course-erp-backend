package com.khazar.org.courseerpbackend.repository;

import com.khazar.org.courseerpbackend.models.mybatis.course.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository {

    void insert(Course course);
}
