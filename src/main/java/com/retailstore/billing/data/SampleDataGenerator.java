package com.retailstore.billing.data;

import com.retailstore.billing.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class SampleDataGenerator {
    public User getUserDetails(User user) {
        HashMap<String, User> userMap = new HashMap();
        if (user != null && user.getMobileNo() != null) {
            User employee = new User(1L, "employee", "9999999999", "employee", LocalDate.now());
            User affliate = new User(2L, "affliate", "9898989898", "affliate", LocalDate.now());
            User customer1 = new User(3L, "customer1", "9797979797", "customer", LocalDate.of(2020, 11, 23));
            User customer2 = new User(4L, "customer2", "9696969696", "customer", LocalDate.of(2019, 12, 23));
            userMap.put("9999999999", employee);
            userMap.put("9898989898", affliate);
            userMap.put("9797979797", customer1);
            userMap.put("9696969696", customer2);
            return userMap.get(user.getMobileNo());
        }
        return user;
    }
}
