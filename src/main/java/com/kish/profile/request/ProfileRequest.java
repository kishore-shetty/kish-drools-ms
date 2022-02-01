package com.kish.profile.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProfileRequest {

    private String name;
    private String email;
    private String password;
    private String dob;
    private AmountRequest salary;
    private List<PhoneNumberRequest> phoneNumbers;
}
