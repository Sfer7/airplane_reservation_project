package com.project.airplane_reservation.company.model;

import lombok.Data;

@Data
public class CompanyRegisterInput {
    private String companyName;
    private String companyNum;
    private String password;
    private String phoneNum;
    private String webPage;
    private String address;
}
