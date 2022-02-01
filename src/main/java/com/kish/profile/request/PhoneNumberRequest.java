package com.kish.profile.request;

import lombok.Data;

@Data
public class PhoneNumberRequest {

    private String type;
    private String countryCode;
    private String number;
}
