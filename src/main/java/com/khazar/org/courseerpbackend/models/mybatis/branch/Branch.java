package com.khazar.org.courseerpbackend.models.mybatis.branch;

import com.khazar.org.courseerpbackend.models.enums.branch.BranchStatus;
import com.khazar.org.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch extends BaseEntity {

    String name;
    BranchStatus status;
    String address;
    Double lat;
    Double lon;
    Long courseId;

}
