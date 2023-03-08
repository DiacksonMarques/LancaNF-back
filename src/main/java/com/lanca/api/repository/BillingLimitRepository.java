package com.lanca.api.repository;

import com.lanca.api.model.BillingLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingLimitRepository extends JpaRepository<BillingLimit, Long> {
}
