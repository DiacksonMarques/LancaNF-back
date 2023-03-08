package com.lanca.api.service;

import com.lanca.api.model.BillingLimit;

public interface BillingLimitService {

    BillingLimit updateBillingLimit(BillingLimit billingLimit);

    BillingLimit getLimit();
}
