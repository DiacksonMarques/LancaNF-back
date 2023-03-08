package com.lanca.api.controller;

import com.lanca.api.model.BillingLimit;
import com.lanca.api.model.Company;
import com.lanca.api.service.BillingLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class BillingLimitController {

    @Autowired
    private BillingLimitService billingLimitService;

    @PutMapping("/api/billing-limit")
    public BillingLimit update(@RequestBody BillingLimit billingLimit) {
        return billingLimitService.updateBillingLimit(billingLimit);
    }

    @GetMapping("/api/billing-limit")
    public BillingLimit get(){
        return billingLimitService.getLimit();
    }
}
