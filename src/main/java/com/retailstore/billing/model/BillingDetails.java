package com.retailstore.billing.model;

import java.util.List;

public class BillingDetails {

    private User user;
    private List<BillingAmount> billingAmount;
    private Double discountAmount;
    private Double finalBillAmount;
    private Double amountEligibleForDiscount;
    private Double amountNotEligibleForDiscount;
    private Integer noOfItems;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BillingAmount> getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(List<BillingAmount> billingAmount) {
        this.billingAmount = billingAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getFinalBillAmount() {
        return finalBillAmount;
    }

    public void setFinalBillAmount(Double finalBillAmount) {
        this.finalBillAmount = finalBillAmount;
    }

    public Double getAmountEligibleForDiscount() {
        return amountEligibleForDiscount;
    }

    public void setAmountEligibleForDiscount(Double amountEligibleForDiscount) {
        this.amountEligibleForDiscount = amountEligibleForDiscount;
    }

    public Double getAmountNotEligibleForDiscount() {
        return amountNotEligibleForDiscount;
    }

    public void setAmountNotEligibleForDiscount(Double amountNotEligibleForDiscount) {
        this.amountNotEligibleForDiscount = amountNotEligibleForDiscount;
    }

    public Integer getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(Integer noOfItems) {
        this.noOfItems = noOfItems;
    }
}
