package com.project.airplane_reservation.company.controller;

import com.project.airplane_reservation.company.model.CompanyRegisterInput;
import com.project.airplane_reservation.company.repository.CompanyRepository;
import com.project.airplane_reservation.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;
    private final CompanyService companyService;

    @PostMapping("/company/register")
    public void registerCompany(@RequestBody CompanyRegisterInput parameter) {
        companyService.register(parameter);
    }
}
