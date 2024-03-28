package com.khazar.org.courseerpbackend.models.mappers;

import com.khazar.org.courseerpbackend.models.mybatis.course.Course;
import com.khazar.org.courseerpbackend.models.payload.auth.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseEntityMapper {

    CourseEntityMapper INSTANCE = Mappers.getMapper(CourseEntityMapper.class);

    @Mapping(target = "name", source = "courseName")
    @Mapping(target = "status" , source = "ACTIVE")
    Course fromSignUpPayload(SignUpPayload payload);
}
