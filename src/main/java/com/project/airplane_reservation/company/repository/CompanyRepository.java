package com.project.airplane_reservation.company.repository;

import com.project.airplane_reservation.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByCompanyNameOrCompanyNum(String companyName, String companyNum);
}
