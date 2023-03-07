package com.project.airplane_reservation.repository;

import com.project.airplane_reservation.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
