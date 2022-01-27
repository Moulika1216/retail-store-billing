package com.retailstore.billing.model;

import org.junit.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testUserGettersAndSetters(){
        User user = new User(1L,"employee","9934343499","employee", LocalDate.now());
        assertEquals(Long.valueOf(1), user.getUserId());
        assertEquals("employee",user.getUsername());
        assertEquals("9934343499",user.getMobileNo());
        assertEquals("employee",user.getUserType());
        assertEquals(LocalDate.now(),user.getCreatedDt());
    }
}
