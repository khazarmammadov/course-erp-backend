package com.khazar.org.courseerpbackend.models.mybatis.course;

import com.khazar.org.courseerpbackend.models.enums.course.CourseStatus;
import com.khazar.org.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {

    String name;
    CourseStatus status;

}
