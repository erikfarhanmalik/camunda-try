package com.erik.learn.repository;

import com.erik.learn.entity.RequestToProcessMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestToProcessMappingRepository extends JpaRepository<RequestToProcessMapping, Long> {
}
