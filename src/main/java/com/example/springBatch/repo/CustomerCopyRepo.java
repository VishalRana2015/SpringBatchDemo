package com.example.springBatch.repo;

import com.example.springBatch.domain.CustomerCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCopyRepo extends JpaRepository<CustomerCopy, Integer> {
}
