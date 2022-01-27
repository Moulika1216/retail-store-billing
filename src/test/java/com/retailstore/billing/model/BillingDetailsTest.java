package com.retailstore.billing.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BillingDetailsTest {

    @InjectMocks
    BillingDetails billingDetails;

    @Test
    public void testBillingDetailsGettersAndSetters(){
        billingDetails.setUser(new User());
        billingDetails.setBillingAmount(new ArrayList(1));
        billingDetails.setDiscountAmount(10.0);
        billingDetails.setAmountEligibleForDiscount(40.0);
        billingDetails.setAmountNotEligibleForDiscount(60.0);
        billingDetails.setFinalBillAmount(90.0);
        billingDetails.setNoOfItems(8);
        Assert.notNull(billingDetails.getUser());
        Assert.notNull(billingDetails.getBillingAmount());
        assertEquals(Double.valueOf(10.0),billingDetails.getDiscountAmount());
        assertEquals(Double.valueOf(40.0),billingDetails.getAmountEligibleForDiscount());
        assertEquals(Double.valueOf(60.0),billingDetails.getAmountNotEligibleForDiscount());
        assertEquals(Double.valueOf(90.0),billingDetails.getFinalBillAmount());
        assertEquals(Integer.valueOf(8),billingDetails.getNoOfItems());

    }
}
