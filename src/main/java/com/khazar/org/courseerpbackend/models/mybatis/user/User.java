package com.khazar.org.courseerpbackend.models.mybatis.user;

import com.khazar.org.courseerpbackend.models.enums.user.UserStatus;
import com.khazar.org.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    String name;
    String surname;
    UserStatus status;
    Long roleId;
    String email;
    String phoneNumber;
    String password;

}