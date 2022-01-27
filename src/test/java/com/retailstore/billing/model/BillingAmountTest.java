package com.retailstore.billing.model;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BillingAmountTest {

    @InjectMocks
    BillingAmount billingAmount;


    @Test
    public void testBillingAmountGettersAndSetters() {
        billingAmount.setProductType("groceries");
        billingAmount.setAmount(22.34);
        assertEquals("groceries",billingAmount.getProductType());
        assertEquals(Double.valueOf(22.34), billingAmount.getAmount());
    }
}
