package com.khazar.org.courseerpbackend.service.branch;

import com.khazar.org.courseerpbackend.models.mybatis.branch.Branch;
import com.khazar.org.courseerpbackend.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchServiceImpl implements BranchService{

    private final BranchRepository branchRepository;
    @Override
    public void insert(Branch branch) {
        branchRepository.insert(branch);
    }
}
