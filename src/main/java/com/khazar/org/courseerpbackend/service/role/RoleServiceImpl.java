package com.khazar.org.courseerpbackend.service.role;

import com.khazar.org.courseerpbackend.exception.BaseException;
import com.khazar.org.courseerpbackend.models.mybatis.role.Role;
import com.khazar.org.courseerpbackend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final static String OWNER = "OWNER";
    private final RoleRepository roleRepository;

    @Override
    public Role getDefaultRole() {
        return roleRepository.findByName(OWNER)
                .orElseThrow(BaseException::unexpected);
    }
}
