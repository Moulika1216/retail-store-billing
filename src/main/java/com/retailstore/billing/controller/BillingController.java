package com.retailstore.billing.controller;

import com.retailstore.billing.modal.BillingDetails;
import com.retailstore.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    @Autowired
    BillingService billingService;

    @PostMapping("/finalBill")
    public BillingDetails getFinalBill(@RequestBody BillingDetails billingDetails) {
        billingDetails = billingService.getFinalBillPostDiscount(billingDetails);
        return billingDetails;
    }
}
