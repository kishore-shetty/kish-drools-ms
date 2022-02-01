package com.kish.profile.domain;

import com.kish.profile.request.PhoneNumberRequest;
import com.kish.profile.request.ProfileRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String dob;
    private String currencyType;
    private BigDecimal salary;
    private BigDecimal salaryInEuro;
    private String phoneNumber;
    private Boolean activeFlag;
    private LocalDateTime updatedDateTime;

    public Profile(ProfileRequest profileRequest) {
        this.name = profileRequest.getName();
        this.email = profileRequest.getEmail();
        this.password = profileRequest.getPassword();
        this.dob = profileRequest.getDob();
        this.currencyType = profileRequest.getSalary().getCurrencyType();
        this.salary = profileRequest.getSalary().getAmount();
        this.salaryInEuro = profileRequest.getSalary().getAmountInEuro();
        PhoneNumberRequest phoneNumberRequest = profileRequest.getPhoneNumbers().get(0);
        this.phoneNumber = phoneNumberRequest.getCountryCode() + phoneNumberRequest.getNumber();
        this.activeFlag = true;
        this.updatedDateTime = LocalDateTime.now();
    }
}

