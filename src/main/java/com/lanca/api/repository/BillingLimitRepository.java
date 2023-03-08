package com.lanca.api.repository;

import com.lanca.api.model.BillingLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingLimitRepository extends JpaRepository<BillingLimit, Long> {
}
