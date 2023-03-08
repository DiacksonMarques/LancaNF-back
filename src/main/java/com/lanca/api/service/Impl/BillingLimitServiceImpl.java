package com.lanca.api.service.Impl;

import com.lanca.api.model.BillingLimit;
import com.lanca.api.repository.BillingLimitRepository;
import com.lanca.api.service.BillingLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingLimitServiceImpl implements BillingLimitService {

    @Autowired
    private BillingLimitRepository billingLimitRepository;

    @Override
    public BillingLimit updateBillingLimit(BillingLimit billingLimit) {
        return billingLimitRepository.save(billingLimit);
    }

    @Override
    public BillingLimit getLimit(){
        List<BillingLimit> limit = billingLimitRepository.findAll();
        return limit.get(0);
    }
}
