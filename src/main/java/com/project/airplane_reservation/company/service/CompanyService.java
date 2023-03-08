package com.project.airplane_reservation.company.service;

import com.project.airplane_reservation.company.domain.Company;
import com.project.airplane_reservation.company.model.CompanyRegisterInput;
import com.project.airplane_reservation.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.project.airplane_reservation.company.domain.CompanyState.COMPANY_STATE_REQUIRE;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void register(CompanyRegisterInput parameter) {
        Optional<Company> optionalCompany = companyRepository.findByCompanyNameOrCompanyNum(parameter.getCompanyName(), parameter.getCompanyNum());
        if(optionalCompany.isPresent()) {
            System.out.println("동일한 회사명 또는 회사번호를 가지고 있습니다.");
            return;
        }

        Company curCompany = Company.builder()
                .companyName(parameter.getCompanyName())
                .companyNum(parameter.getCompanyNum())
                .password(parameter.getPassword())
                .phoneNum(parameter.getPhoneNum())
                .webPage(parameter.getWebPage())
                .address(parameter.getAddress())
                .regDate(LocalDate.now())
                .totalRegItems(0)
                .totalSales(0)
                .state(COMPANY_STATE_REQUIRE)
                .build();
        companyRepository.save(curCompany);
    }
}
