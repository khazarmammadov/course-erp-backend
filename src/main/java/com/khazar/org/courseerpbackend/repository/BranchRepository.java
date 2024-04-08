package com.khazar.org.courseerpbackend.repository;

import com.khazar.org.courseerpbackend.models.mybatis.branch.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchRepository {

    void insert(Branch branch);
}
