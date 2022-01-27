package com.retailstore.billing.service;

import com.retailstore.billing.data.SampleDataGenerator;
import com.retailstore.billing.model.BillingAmount;
import com.retailstore.billing.model.BillingDetails;
import com.retailstore.billing.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BillingServiceTest {

    @InjectMocks
    BillingService billingService;

    @Mock
    SampleDataGenerator sampleDataGenerator;

    BillingDetails billingDetails = null;
    User user = null;

    @Before
    public void init() {
        billingDetails = new BillingDetails();
        List<BillingAmount> billList = new ArrayList(2);
        BillingAmount amount = new BillingAmount();
        amount.setProductType("groceries");
        amount.setAmount(280.0);
        billList.add(amount);
        amount = new BillingAmount();
        amount.setProductType("others");
        amount.setAmount(990.0);
        billList.add(amount);
        billingDetails.setBillingAmount(billList);
        billingDetails.setNoOfItems(8);
    }

    @Test
    public void testFinalBillPostDiscountForEmployee() {
        user = new User(1L, "employee", "9999999999", "employee", LocalDate.now());
        Mockito.when(sampleDataGenerator.getUserDetails(user)).thenReturn(user);
        billingDetails.setUser(user);
        billingDetails=billingService.getFinalBillPostDiscount(billingDetails);
        assertEquals(Double.valueOf(342.0), billingDetails.getDiscountAmount());
        assertEquals(Double.valueOf(928.0), billingDetails.getFinalBillAmount());
    }

    @Test
    public void testFinalBillPostDiscountForAffliate() {
        user = new User(2L, "affliate", "9898989898", "affliate", LocalDate.now());
        Mockito.when(sampleDataGenerator.getUserDetails(user)).thenReturn(user);
        billingDetails.setUser(user);
        billingDetails=billingService.getFinalBillPostDiscount(billingDetails);
        assertEquals(Double.valueOf(154.0), billingDetails.getDiscountAmount());
        assertEquals(Double.valueOf(1116.0), billingDetails.getFinalBillAmount());
    }

    @Test
    public void testFinalBillPostDiscountForCustomerLessthanTwoYears() {
        user = new User(3L, "customer1", "9797979797", "customer", LocalDate.of(2020, 11, 23));
        Mockito.when(sampleDataGenerator.getUserDetails(user)).thenReturn(user);
        billingDetails.setUser(user);
        billingDetails=billingService.getFinalBillPostDiscount(billingDetails);
        assertEquals(Double.valueOf(60.0), billingDetails.getDiscountAmount());
        assertEquals(Double.valueOf(1210.0), billingDetails.getFinalBillAmount());
    }

    @Test
    public void testFinalBillPostDiscountForCustomerMorethanTwoYears() {
        user = new User(4L, "customer2", "9696969696", "customer", LocalDate.of(2019, 12, 23));
        Mockito.when(sampleDataGenerator.getUserDetails(user)).thenReturn(user);
        billingDetails.setUser(user);
        billingDetails=billingService.getFinalBillPostDiscount(billingDetails);
        assertEquals(Double.valueOf(109.5), billingDetails.getDiscountAmount());
        assertEquals(Double.valueOf(1160.5), billingDetails.getFinalBillAmount());
    }

    @Test
    public void testFinalBillPostDiscountForCustomerLessthanTwoYearsWithNoDiscount() {
        List<BillingAmount> billList = new ArrayList(2);
        BillingAmount amount = new BillingAmount();
        amount.setProductType("groceries");
        amount.setAmount(0.0);
        billList.add(amount);
        amount = new BillingAmount();
        amount.setProductType("others");
        amount.setAmount(50.0);
        billList.add(amount);
        billingDetails.setBillingAmount(billList);
        user = new User(3L, "customer1", "9797979797", "customer", LocalDate.of(2020, 11, 23));
        Mockito.when(sampleDataGenerator.getUserDetails(user)).thenReturn(user);
        billingDetails.setUser(user);
        billingDetails=billingService.getFinalBillPostDiscount(billingDetails);
        assertEquals(Double.valueOf(0.0), billingDetails.getDiscountAmount());
        assertEquals(Double.valueOf(50.0), billingDetails.getFinalBillAmount());
    }

}
