package com.retailstore.billing.service;

import com.retailstore.billing.data.SampleDataGenerator;
import com.retailstore.billing.modal.BillingAmount;
import com.retailstore.billing.modal.BillingDetails;
import com.retailstore.billing.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    SampleDataGenerator dataGenerator;

    public BillingDetails getFinalBillPostDiscount(BillingDetails billingDetails) {
        billingDetails = getUserType(billingDetails);
        billingDetails = getBillAmountForDiscount(billingDetails);
        billingDetails = getDiscount(billingDetails);
        billingDetails = getFinalBill(billingDetails);
        return billingDetails;
    }

    private BillingDetails getFinalBill(BillingDetails billingDetails) {
        Double finalBill = billingDetails.getAmountNotEligibleForDiscount() + billingDetails.getAmountEligibleForDiscount() - billingDetails.getDiscountAmount();
        billingDetails.setFinalBillAmount(finalBill);
        return billingDetails;
    }

    private BillingDetails getDiscount(BillingDetails billingDetails) {
        User user = billingDetails.getUser();
        String userType = user != null && user.getUserType() != null ? user.getUserType() : "newUser";
        Double discountAmount = 0.0;
        Double billAmntForDiscount = billingDetails.getAmountEligibleForDiscount();
        Double amntWithNoDiscount = billingDetails.getAmountNotEligibleForDiscount();
        switch (userType) {
            case "employee":
                discountAmount = billAmntForDiscount * 0.3;
                break;
            case "affliate":
                discountAmount = billAmntForDiscount * 0.1;
                break;
            case "customer":
                if (LocalDate.now().minusYears(2).isAfter(user.getCreatedDt())) {
                    discountAmount = billAmntForDiscount * 0.05;
                }
                break;
        }
        discountAmount += (Math.floor((billAmntForDiscount + amntWithNoDiscount - discountAmount) / 100)) * 5;
        billingDetails.setDiscountAmount(discountAmount);
        return billingDetails;
    }

    private BillingDetails getBillAmountForDiscount(BillingDetails billingDetails) {
        Double billAmntForDiscount = 0.0;
        Double amntWithNoDiscount = 0.0;
        List<BillingAmount> billingList = billingDetails.getBillingAmount();
        for (BillingAmount bill : billingList) {
            if ("groceries".equalsIgnoreCase(bill.getProductType())) {
                amntWithNoDiscount += bill.getAmount();
            } else {
                billAmntForDiscount += bill.getAmount();
            }
        }
        billingDetails.setAmountEligibleForDiscount(billAmntForDiscount);
        billingDetails.setAmountNotEligibleForDiscount(amntWithNoDiscount);
        return billingDetails;
    }

    private BillingDetails getUserType(BillingDetails billingDetails) {
        User user = dataGenerator.getUserDetails(billingDetails.getUser());
        billingDetails.setUser(user);
        return billingDetails;
    }
}
