package com.retailstore.billing.controller;

import com.retailstore.billing.model.BillingDetails;
import com.retailstore.billing.service.BillingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

@WebMvcTest(value = BillingController.class)
@RunWith(SpringRunner.class)
public class BillingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    BillingController billingController;

    @MockBean
    BillingService billingService;

    @Autowired
    MockMvc mockMVC = null;
    String billingDetailsReqJson = null;
    String billingDetailsRespJson = null;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMVC = MockMvcBuilders.standaloneSetup(billingController).build();
        billingDetailsReqJson="{\n" +
                "    \"user\":{\n" +
                "        \"mobileNo\":\"9898989898\"\n" +
                "    },\n" +
                "    \"billingAmount\":[{\n" +
                "        \"productType\":\"groceries\",\n" +
                "        \"amount\":280\n" +
                "    },\n" +
                "    {\n" +
                "        \"productType\":\"others\",\n" +
                "        \"amount\":990\n" +
                "    }],\n" +
                "    \"finalBillAmount\":890,\n" +
                "    \"noOfItems\":8\n" +
                "}";
        billingDetailsRespJson="{\n" +
                "    \"user\": {\n" +
                "        \"userId\": 2,\n" +
                "        \"username\": \"affliate\",\n" +
                "        \"mobileNo\": \"9898989898\",\n" +
                "        \"userType\": \"affliate\",\n" +
                "        \"createdDt\": \"2022-01-27\"\n" +
                "    },\n" +
                "    \"billingAmount\": [\n" +
                "        {\n" +
                "            \"productType\": \"groceries\",\n" +
                "            \"amount\": 280.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"productType\": \"others\",\n" +
                "            \"amount\": 990.0\n" +
                "        }\n" +
                "    ],\n" +
                "    \"discountAmount\": 154.0,\n" +
                "    \"finalBillAmount\": 1116.0,\n" +
                "    \"amountEligibleForDiscount\": 990.0,\n" +
                "    \"amountNotEligibleForDiscount\": 280.0,\n" +
                "    \"noOfItems\": 8\n" +
                "}";
    }

    @Test
    public void testGetFinalBill() throws Exception {
        Mockito.when(billingService.getFinalBillPostDiscount(new BillingDetails())).thenReturn(new BillingDetails());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/finalBill")
                .content(billingDetailsReqJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
}
